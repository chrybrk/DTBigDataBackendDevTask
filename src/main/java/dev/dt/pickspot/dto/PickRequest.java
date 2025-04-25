package dev.dt.pickspot.dto;

import java.util.List;
import java.util.Map;
import dev.dt.pickspot.model.Container;
import dev.dt.pickspot.model.Slot;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PickRequest {

  @JsonProperty	Container container;
  @JsonProperty List<Slot> yardMap;

	public PickRequest(Container c, List<Slot> slots) {
		this.container = c;
		this.yardMap = slots;
	}

	public void setContainer(Container container) {
		this.container = container;
	}

	public void setYardMap(List<Slot> yardMap) {
		this.yardMap = yardMap;
	}

	public Container container() {
		return this.container;
	}

	public List<Slot> yardMap() {
		return this.yardMap;
	}

}
