package lk.jiat.zlibrary.entity;

/**
 *
 * @author Yashitha
 */
public enum BookStatus {
    ISSUED(1), RETURNED(2), LATE_RETURNED(3), OVERDUE(4);

    private final int id;

    BookStatus(int id){
        this.id = id;
    }

    public int getId() {
        return this.id;
    }
}
