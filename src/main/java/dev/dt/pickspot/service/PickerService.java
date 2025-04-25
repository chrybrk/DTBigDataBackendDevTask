package dev.dt.pickspot.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import dev.dt.pickspot.model.Slot;
import dev.dt.pickspot.model.Container;

@Service
public class PickerService {
	private static final int INVALID = 10_000;

	public Optional<Slot> chooseBestSlot(Container c, List<Slot> slots) {
		final boolean cSize = c.size().equals("big");
		final boolean cNeedsCold = c.needsCold();
		final int cX = c.x();
		final int cY = c.y();
		Slot bestSlot = null;
		int bestDistance = INVALID + 1;

		for (Slot s : slots) {
			if (cSize && s.sizeCap().equals("small")) continue;
			if (cNeedsCold && !s.hasColdUnit()) continue;
			if (s.occupied()) continue;

			int distance = Math.abs(c.x() - s.x()) + Math.abs(c.y() - s.y());		
			if (distance < bestDistance) {
				bestDistance = distance;
				bestSlot = s;
			}
		}

		return bestDistance >= INVALID ? Optional.empty() : Optional.of(bestSlot);
	}
}
