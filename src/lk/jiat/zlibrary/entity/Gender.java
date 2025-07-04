package lk.jiat.zlibrary.entity;


public enum Gender {
    
    MALE(1),FEMALE(2);
    
    private final int id; 
    
    Gender(int id){
        this.id = id;
    }
    
    public int getId(){
        return this.id;
    }
    
}
