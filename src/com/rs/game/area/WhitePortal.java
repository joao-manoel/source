package com.rs.game.area;

import com.rs.game.WorldTile;
import com.rs.game.area.shapes.Polygon;

public class WhitePortal extends Area {

	@Override
	public Area update() {
		return this;
	}

	@Override
	public String name() {
		return "White Portal";
	}
	//lado 2752 - 5613 , 2894 5618
	@Override
	public Shape[] shapes() {
		return new Shape[] { new Polygon(new WorldTile[] { new WorldTile(2814, 5638, 0), new WorldTile(2814, 5540, 0),
				new WorldTile(2894, 5613, 0), new WorldTile(2752, 5613, 0) }) };
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
