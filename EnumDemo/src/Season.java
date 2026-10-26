public enum Season {
    SPRING("春天", 1), SUMMER("夏天", 2),
    AUTUMN("秋天", 3), WINTER("冬天", 4);

    private final String cnName;
    private final int order;

    Season(String cnName, int order) {
        this.cnName = cnName;
        this.order = order;
    }

    public String getCnName() { return cnName; }

    public int getOrder() {
        return order;
    }

    @Override
    public String toString() {
        return "Season{" +
                "cnName='" + cnName + '\'' +
                '}';
    }

    public static void main(String[] args) {
        for(Season s : Season.values()) {
            switch (s) {
                case SPRING:
                    System.out.println("春天来了");break;
                case SUMMER:
                    System.out.println("夏天来了");break;
                case AUTUMN:
                    System.out.println("秋天来了");break;
                case WINTER:
                    System.out.println("冬天来了");
            }
        }

        System.out.println(Season.SPRING);
    }
}
