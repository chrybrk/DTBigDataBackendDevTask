package dev.dt.pickspot;

import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import dev.dt.pickspot.model.Container;
import dev.dt.pickspot.model.Slot;
import dev.dt.pickspot.service.PickerService;
import java.util.List;

@SpringBootTest
class PickspotApplicationTests {

	@Autowired private PickerService picker;

	@Test
	void yardFullReturnsEmpty() {
		Container c = new Container("X","small",false,0,0);
		List<Slot> full = List.of(new Slot(0,1,"small",false,true));

		assertTrue(picker.chooseBestSlot(c, full).isEmpty());	
	}	

}
