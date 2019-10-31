package regiment;

import armies.generalModel.Model;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class FormationMethodsTest {

    FormationMethods formationMethods;
    Model model;
    Rank rank;
    Unit unit;

    @BeforeEach
    void init(){
        formationMethods = new FormationMethods();
    }

    @Test
    void testCreateRank() {
        int modelAmount = 5;
        Rank rank = formationMethods.createRank(model,modelAmount);
        Map<Integer,Model> testMap = rank.getRankMap();

        assertNotNull(testMap);
        assertEquals(testMap.size(),modelAmount);
    }

    @Test
    void testCreateUnit() {
        int rankAmount = 4;
        Unit unit = formationMethods.createUnit(rank,rankAmount);
        Map<Integer,Rank> testMap = unit.getUnitMap();

        assertNotNull(testMap);
        assertEquals(testMap.size(),rankAmount);
    }

    @Test
    void printUnit() {
//        String firstRank = "O O O ";
//        int modelAmount = 1;
//        Rank rank = formationMethods.createRank(model,modelAmount);
//        int rankAmount = 3;
//        Unit unit = formationMethods.createUnit(rank,rankAmount);
//        formationMethods.printUnit(unit,'O');
//        assertEquals(firstRank,1);
    }
}