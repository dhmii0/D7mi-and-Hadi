import { dialogueData, scaleFactor } from "./constants";
import { k } from "./kaboomCtx";
import { displayDialogue, setCamScale } from "./utils";

k.loadSprite("spritesheet", "./spritesheet.png", {
  sliceX: 39,
  sliceY: 31,
  anims: {
    "idle-down": 940,
    "walk-down": { from: 940, to: 943, loop: true, speed: 8 },
    "idle-side": 979,
    "walk-side": { from: 979, to: 982, loop: true, speed: 8 },
    "idle-up": 1018,
    "walk-up": { from: 1018, to: 1021, loop: true, speed: 8 },
  },
});
 
k.loadSprite("map1", "./map1.png");

k.setBackground(k.Color.fromHex("#311047"));

k.scene("main", async () => {
  const mapData = await (await fetch("./map1.json")).json();
  const layers = mapData.layers;

  const map = k.add([k.sprite("map1"), k.pos(0), k.scale(scaleFactor)]);

  const player = k.make([
    k.sprite("sprite", { anim: "idle-down" }),
    k.area({
      shape: new k.Rect(k.vec2(0, 3), 10, 10),
    }),
    k.body(),
    k.anchor("center"),
    k.pos(),
    k.scale(scaleFactor),
    {
      speed: 250,
      direction: "down",
      isInDialogue: false,
    },
    "player",
  ]);

  for (const layer of layers) {
    if (layer.name === "boundaries") {
      for (const boundary of layer.objects) {
        map.add([
          k.area({
            shape: new k.Rect(k.vec2(0), boundary.width, boundary.height),
          }),
          k.body({ isStatic: true }),
          k.pos(boundary.x, boundary.y),
          boundary.name,
        ]);

        if (boundary.name) {
          player.onCollide(boundary.name, () => {
            player.isInDialogue = true;
            displayDialogue(
              dialogueData[boundary.name],
              () => (player.isInDialogue = false)
            );
          });
        }
      }

      continue;
    }

    if (layer.name === "spawnpoints") {
      for (const entity of layer.objects) {
        if (entity.name === "player") {
          player.pos = k.vec2(
            (map.pos.x + entity.x) * scaleFactor,
            (map.pos.y + entity.y) * scaleFactor
          );
          k.add(player);
          continue;
        }
      }
    }
  }

  setCamScale(k);

  k.onResize(() => {
    setCamScale(k);
  });

  k.onUpdate(() => {
    k.camPos(player.worldPos().x, player.worldPos().y - 100);
  });

  k.onMouseDown((mouseBtn)=> {
    if (mouseBtn !== "left" || player.isInDialogue )  return; 

    const worldMouseDowen= k.toWorld(k.mousePos());
    player.moveTo(worldMousePos, player.speed);

    const mouseAngel = player.pos.angle(worldMousePos);

    const lowerBoned = 50;
    const upperBond = 125;

    if (
        mouseAngel> lowerBoned &&
        mouseAngel <upperBond && 
        player.curAnim() !== "walk-up"
    ) {
        player.play("walk-up");
        player.direction = "up";
        return;
    }

    if(
        mouseAngel < -lowerBoned &&
        mouseAngel > - upperBond &&
        player.curAnim() !== "walk-down"
    ) {
        player.play("walk-down")
        player.direction = "doen";
        return;
    }

    if(Math.abs(mouseAngel)> upperBond){
        player.flipX = false;
        if (player.curAnim() !== "walk-side") player.play("walk-side");
        return;

    }

    if (Math.abs(mouseAngle)< lowerBoned){
        player.flipX = true;
        if (player.curAnim() !== "walk-side") player.play("walk-side");
        player.direction = "left";
        return;
    }
  });

  function stopAnims(){
    if (player.direction === "down"){
        player.play("idle-down");
        return;
    }
    if(player.direction=== "up"){
        player.play("idle-up");
        return;
    }

    player.play("idle-side");
  }

  k.onMouseRelease(stopAnims);

  k.onMouseRelease(()=> {
    stopAnims();
  });
  k.onKeyDown((key)=> {
    const keyMap = [
        k.isKeyDown("right"),
        k.isKeyDown("left"),
        k.isKeyDown("up"),
        k.isKeyDown("down"),
    ];

    let nb0fkeyPressed = 0;
    for (const key of keyMap){
        if (key){
            nb0fkeyPressed++;
        }
    }

    if (nb0fkeyPressed> 1 ) return;
    if (player.isInDialogue)return;

    if (keyMap[0]){
        player.flipX = false;
        if (player.curAnim()!== "walk-side") player.play("walk-side");
        player.direction= "right";
        return;
    }

    if (keyMap[1]) {
        player.flipX = true;
        if (player.curAnim() !== "walk-side") player.play("walk-side");
        player.direction = "left";
        player.move(-player.speed, 0);
        return;
      }
  
      if (keyMap[2]) {
        if (player.curAnim() !== "walk-up") player.play("walk-up");
        player.direction = "up";
        player.move(0, -player.speed);
        return;
      }
  
      if (keyMap[3]) {
        if (player.curAnim() !== "walk-down") player.play("walk-down");
        player.direction = "down";
        player.move(0, player.speed);
      }
  })
});

k.go("main");