## ✨ 2D GAME

This project is focused on learning game development concepts and improving java skills 

## 💡THE IDEA

It consists of a platform game that involves shooting enemies and going through increasingly levels

### Diagram

```
classDiagram
Entity <|-- Player

class Entity {
    private int x;
    private int y;
    private int width;
    private int height;
    private Rectangle hitbox
    private int xSpeed;
    private int ySpeed;
    private boolean moving;
    private String action;
    private BufferedImage[][] animations;
    private int animationTick;
    private int ticksPerFrame;

    render()
    update()
    drawHitbox()
    verifyValidPosition()

}

class Player {
    atack()
}

class Creature
```