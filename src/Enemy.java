public abstract class Enemy {
    AIState state;

    public void move() {

    }
}
abstract class Gob extends Enemy {
    gobClass gc;
    gobSize gs;
    public static interface gobClass {
        class Archer implements gobClass {
        }
        class Fighter implements gobClass {
        }
    }

    public static interface gobSize {
        class Normal implements gobSize {
        }
        class Mini implements gobSize {

        }
    }
}
abstract class SpGob extends Enemy {
    public static class Imp extends SpGob {
    }
    public static class Mystic extends SpGob {
    }
}
class Slime extends Enemy {
}
enum AIState{
    IDLE, COMBAT
}

