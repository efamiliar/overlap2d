package com.uwsoft.editor.view.ui.properties.panels;

import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.math.Vector2;
import com.uwsoft.editor.renderer.components.physics.PhysicsBodyComponent;
import com.uwsoft.editor.view.ui.properties.UIItemPropertiesMediator;
import org.apache.commons.lang3.math.NumberUtils;

/**
 * Created by CyberJoe on 7/5/2015.
 */
public class UIPhysicsPropertiesMediator extends UIItemPropertiesMediator<Entity, UIPhysicsProperties> {

    private static final String TAG = UIPhysicsPropertiesMediator.class.getCanonicalName();
    public static final String NAME = TAG;

    private PhysicsBodyComponent physicsComponent;

    public UIPhysicsPropertiesMediator() {
        super(NAME, new UIPhysicsProperties());
    }

    @Override
    protected void translateObservableDataToView(Entity item) {
        physicsComponent = item.getComponent(PhysicsBodyComponent.class);
        viewComponent.setBodyType(physicsComponent.bodyType);
        viewComponent.getMassField().setText(physicsComponent.mass + "");
        viewComponent.getCenterOfMassXField().setText(physicsComponent.centerOfMass.x + "");
        viewComponent.getCenterOfMassYField().setText(physicsComponent.centerOfMass.y + "");
        viewComponent.getRotationalIntertiaField().setText(physicsComponent.rotationalInertia + "");
        viewComponent.getDumpingField().setText(physicsComponent.damping + "");
        viewComponent.getGravityScaleField().setText(physicsComponent.gravityScale + "");
        viewComponent.getDensityField().setText(physicsComponent.density + "");
        viewComponent.getFrictionField().setText(physicsComponent.friction + "");
        viewComponent.getRestitutionField().setText(physicsComponent.restitution + "");
        viewComponent.getAllowSleepBox().setChecked(physicsComponent.allowSleep);
        viewComponent.getAwakeBox().setChecked(physicsComponent.awake);
        viewComponent.getBulletBox().setChecked(physicsComponent.bullet);
    }

    @Override
    protected void translateViewToItemData(Object customData) {
        physicsComponent = observableReference.getComponent(PhysicsBodyComponent.class);
        physicsComponent.bodyType = viewComponent.getBodyType();
        physicsComponent.mass = NumberUtils.toFloat(viewComponent.getMassField().getText());

        physicsComponent.centerOfMass = new Vector2(NumberUtils.toFloat(viewComponent.getCenterOfMassXField().getText()), NumberUtils.toFloat(viewComponent.getCenterOfMassYField().getText()));

        physicsComponent.rotationalInertia = NumberUtils.toFloat(viewComponent.getRotationalIntertiaField().getText());
        physicsComponent.damping = NumberUtils.toFloat(viewComponent.getDumpingField().getText());
        physicsComponent.gravityScale = NumberUtils.toFloat(viewComponent.getGravityScaleField().getText());
        physicsComponent.density = NumberUtils.toFloat(viewComponent.getDensityField().getText());
        physicsComponent.friction = NumberUtils.toFloat(viewComponent.getFrictionField().getText());
        physicsComponent.restitution = NumberUtils.toFloat(viewComponent.getRestitutionField().getText());

        physicsComponent.allowSleep = viewComponent.getAllowSleepBox().isChecked();
        physicsComponent.awake = viewComponent.getAwakeBox().isChecked();
        physicsComponent.bullet = viewComponent.getBulletBox().isChecked();

    }
}
