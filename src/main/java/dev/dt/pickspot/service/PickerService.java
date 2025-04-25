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
    Slot bestSlot = null;
    int bestDistance = Integer.MAX_VALUE;
    
    final int contX = c.x();
    final int contY = c.y();
    final boolean needsCold = c.needsCold();
    final boolean isBigContainer = c.size().equals("big");
    
    for (Slot s : slots) {
			if (
				s.occupied() ||
				needsCold && !s.hasColdUnit() ||
				isBigContainer && s.sizeCap().equals("small")
			) continue;
			
			int distance = Math.abs(contX - s.x()) + Math.abs(contY - s.y());
			
			if (distance == 0)
				return Optional.of(s);
			
			if (distance < bestDistance) {
				bestDistance = distance;
				bestSlot = s;
			}
    }

    return Optional.empty();
	}
}
