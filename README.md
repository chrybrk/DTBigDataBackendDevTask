# Pick‑a‑Spot API	
## Build & Run	
mvn spring-boot:run	
## Endpoint	
POST /pickSpot	
Body: { container, yardMap }  (see request.json)	
## Testing	
mvn test   # runs PickerServiceTest	
## Design notes	
- Stateless: every call keeps no server memory.	
- Score constant INVALID=10_000 ensures invalid slots never chosen.	
- For yard < 400 slots, O(n) scan is <50 ms; adequate for spec.	
