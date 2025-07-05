package lk.jiat.neolibrary.entity;

public enum Genre {
    FICTION(1),
    NON_FICTION(2),
    SCIENCE(3),
    TECHNOLOGY(4),
    HISTORY(5),
    BIOGRAPHY(6),
    MYSTERY(7),
    FANTASY(8),
    ROMANCE(9),
    HORROR(10),
    THRILLER(11),
    SELF_HELP(12),
    POETRY(13),
    ART(14),
    RELIGION(15),
    TRAVEL(16),
    CHILDREN(17),
    EDUCATION(18),
    COMICS(19),
    HEALTH(20);
    
    private final int id;

    Genre(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
