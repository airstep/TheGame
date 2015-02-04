package com.tgs.thegame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

public class Game extends SimpleApplication {

    private Geometry boxGeometry;

    @Override
    public void simpleInitApp() {
        setDisplayFps(false);
        setDisplayStatView(false);

        Box box = new Box(1, 1, 1);
        boxGeometry = new Geometry("Box", box);

        Material material = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey textureKey = new TextureKey("Textures/Jasmine.jpg");

        Texture texture = assetManager.loadTexture(textureKey);
        material.setTexture("ColorMap", texture);

        boxGeometry.setLocalTranslation(0, 0, 2);
        boxGeometry.setMaterial(material);

        rootNode.attachChild(boxGeometry);
    }

    @Override
    public void simpleUpdate(float tpf) {
        super.simpleUpdate(tpf);
        boxGeometry.rotate(0.5f * tpf, 0.5f * tpf, 0.5f * tpf);
    }
}
