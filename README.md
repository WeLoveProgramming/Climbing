Climbing

Global variable:
int ClimbingSpeed


Objects:

Avatar:
int HP
weapon Weapon
int xpos, ypos //determines point of view


Object:
enum type
int damage
boolean isActive


Obstacles:
int xpos, ypos
method tickAction()


Enemies extends Obstacles:
@inherited
int xpos, ypos
@new members
boolean isMoving
enum directionMoving 
@override
method tickAction()
    attack()


Components:

On every tickAction:
Background picture, a looping picture that is continous, ypos-=fallingSpeed
Obstacles and enemies, ypos+=ClimbingSpeed  
enemies.move()
if weapon collides, then enemies.ypos-- and enemies.hp--
if avatar collides, then backgound.ypos--,avatar.hp--, enemies.ypos++, obstacle.ypos--, ClimbingSpeed--
//if weapon.active==true then weapon.continueSwipe(), weapon.active = false
avatar.ClimbingSpeed++


Tilt left:
then enemies.xpos--, obstacle.xpos--, background.xpos--


Tilt right:
 then enemies.xpos++, obsticle.xpos++, background.xpos++


Tap:
 then weapon.active = true, weapon.swipe(int degree)


EventWhenHP==0:
 GameOver()
 ScoreOutput()
