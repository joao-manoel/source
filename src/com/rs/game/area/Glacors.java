package com.rs.game.area;

import com.rs.game.WorldTile;
import com.rs.game.area.shapes.Polygon;

public class Glacors extends Area {

	@Override
	public Area update() {
		return this;
	}

	@Override
	public String name() {
		return "Glacors";
	}

	@Override
	public Shape[] shapes() {
		return new Shape[] { new Polygon(new WorldTile[] { new WorldTile(4173, 5747, 0), new WorldTile(4173, 5685, 0),
				new WorldTile(4239, 5716, 0), new WorldTile(4152, 5716, 0) }) };
	}

	@Override
	public boolean member() {
		return false;
	}

	@Override
	public Environment environment() {
		return Environment.NORMAL;
	}

}
