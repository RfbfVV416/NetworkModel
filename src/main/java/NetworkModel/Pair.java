package NetworkModel;

public class Pair<UUID, Double> {
    private UUID id;
    private Double weight;
    public Pair(UUID id, Double weight){
        this.id = id;
        this.weight = weight;
    }
    public UUID getFirst(){ return id; }
    public Double getSecond(){ return weight; }
    public void setFirst(UUID id){ this.id = id; }
    public void setSecond(Double weight){ this.weight = weight; }
}

