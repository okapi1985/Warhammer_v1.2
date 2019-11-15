package closeCombat;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import regiment.Unit;

import static org.mockito.Mockito.*;


class CloseCombatPhaseTest {

    @BeforeEach
    void init(){
        CloseCombatPhase closeCombatPhase = new CloseCombatPhase();
    }

    @Test
    void testOfInitiativeTestMethod() {
        Unit unit1 = mock(Unit.class);
        Unit unit2 = mock(Unit.class);


        when(unit1.getUnitMap().get(0).get(0).getInitiative()).thenReturn(5);
        when(unit2.getUnitMap().get(0).get(0).getInitiative()).thenReturn(4);



    }


}