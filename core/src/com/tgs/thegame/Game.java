package com.tgs.thegame;

import com.jme3.app.SimpleApplication;
import com.jme3.asset.TextureKey;
import com.jme3.material.Material;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.texture.Texture;

public class Game extends SimpleApplication {

    private Geometry boxGeometry;
    private Node boxNode;

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


        boxNode = new Node("boxNode");
        boxNode.attachChild(boxGeometry);
        boxNode.rotate(25, 25, 25);

        rootNode.attachChild(boxNode);
    }

    @Override
    public void simpleUpdate(float tpf) {
        super.simpleUpdate(tpf);
        boxGeometry.rotate(0.1f * tpf, 0.1f * tpf, 0.1f * tpf);
        boxGeometry.move(0.1f * tpf, 0.1f * tpf, 0.1f * tpf);
        boxNode.rotate(tpf, tpf, tpf);
    }
}
