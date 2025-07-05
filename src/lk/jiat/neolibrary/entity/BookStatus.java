package lk.jiat.neolibrary.entity;

/**
 *
 * @author Yashitha
 */
public enum BookStatus {
    OWNED(1),ISSUED(2), RETURNED(3), LATE_RETURNED(4), OVERDUE(5);

    private final int id;

    BookStatus(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
