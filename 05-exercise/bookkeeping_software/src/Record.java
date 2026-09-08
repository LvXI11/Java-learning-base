
public class Record {
    public double amount;      // 金额
    public String type;        // 类型：收入/支出
    public String category;    // 类别：餐饮/交通/工资等
    public String note;        // 备注
    public String date;        // 日期：如 2026-09-08

    public Record(double amount, String type, String category, String note, String date) {
        this.amount = amount;
        this.type = type;
        this.category = category;
        this.note = note;
        this.date = date;
    }
}