package com.tgs.thegame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

public class Game extends SimpleApplication {

    @Override
    public void simpleInitApp() {
        Box b = new Box(1, 1, 1);
        Geometry geom = new Geometry("Box", b);

        setDisplayFps(false);
        setDisplayStatView(false);

        Material mat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        TextureKey key = new TextureKey("Textures/Aladdin.jpg");
        Texture tex = assetManager.loadTexture(key);
        mat.setTexture("ColorMap", tex);
        geom.setMaterial(mat);

        rootNode.attachChild(geom);
    }
}
