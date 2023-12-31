import java.util.HashMap;
import java.util.Map;

class Character {
    String nameOfCharacter;
    Map<Integer, Ability> abilities = new HashMap<>();

    boolean isAbilityReady(int abilityNumber) {
        Ability ability = abilities.get(abilityNumber);
        if (ability != null) {
            return ability.isReady();
        }
        return false;
    }


    void useAbility(int abilityNumber) {
        Ability ability = abilities.get(abilityNumber);
        if (ability != null) {
            ability.use();
        }
    }

}