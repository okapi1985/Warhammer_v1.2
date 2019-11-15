package regiment;

import armies.generalModel.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.PrintStream;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

class FormationMethodsTest {

    FormationMethods formationMethods;
    Model model;
    Unit unit;

    @BeforeEach
    void init(){
        formationMethods = new FormationMethods();
    }

    @Test
    void testCreateUnit() {
        int rankAmount = 4;
        int rankSize = 5;
        Unit unit = formationMethods.createUnit(model,rankAmount,rankSize);
        TreeMap<Integer,TreeMap<Integer,Model>> testMap = unit.getUnitMap();

        assertNotNull(testMap);
        assertEquals(testMap.size(),rankAmount);
    }

    @Test
    void printUnit() {

//        formationMethods.out = Mockito.spy(new PrintStream());
//
//        doNothing().when(formationMethods.out).println("O O");
//
//        formationMethods.printUnit();
//
//        Mockito.verify(formationMethods.out, Mockito.times(1)).println("O O");
    }
}