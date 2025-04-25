package dev.dt.pickspot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PickResponse {
    @JsonProperty String id;
    @JsonProperty int targetX;
    @JsonProperty int targetY;

		public PickResponse(String id, int targetX, int targetY) {
			this.id = id;
			this.targetX = targetX;
			this.targetY = targetY;
		}

		public String getId() {
			return this.id;
		}

		public int getTargetX() {
			return this.targetX;
		}

		public int getTargetY() {
			return this.targetY;
		}
}
