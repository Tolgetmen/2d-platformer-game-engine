package com.game.weapons.projectiles;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.game.engine.entity.Entity;
import com.game.engine.handlers.Assets;
import com.game.engine.handlers.Vars;
import com.game.engine.projectile.Projectile;
import com.game.engine.screen.GameScreen;

public class GreenLaser extends Projectile{

	public GreenLaser(GameScreen screen, Vector2 destination, Entity originEntity, World world) {
		super(screen, destination, originEntity, world);
		speed = 3f;

		defineSprite();
	}

	@Override
	protected void defineSprite() {
		sprite = new Sprite(Assets.manager.get(Assets.greenLaser, Texture.class));
		sprite.setBounds(0, 0, 14/Vars.PPM, 8/Vars.PPM);
		sprite.setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
	}
	@Override
	public void update(float dt) {
		super.update(dt);
		//Force
		body.applyLinearImpulse(new Vector2(originToDest.x * speed, originToDest.y * speed), body.getWorldCenter(), true);
		body.applyForceToCenter(new Vector2(0, -Vars.GRAVITY), true);
	}

}
