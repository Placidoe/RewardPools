
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;

/**
 * TODO
 *
 * @Description
 * @Author Lx
 * @Date 2024/11/11 上午9:30
 **/
public class GetDate_Test {
    public static void main(String[] args) {
        //1.计算当前时间戳距离今年开始的日期天数
        // 获取当前日期
        LocalDate currentDate = LocalDate.now(ZoneId.systemDefault());

        // 获取今年的1月1日
        LocalDate startOfYear = LocalDate.of(currentDate.getYear(), 1, 1);

        // 计算当前日期与今年1月1日之间的天数差
        long daysSinceStartOfYear = ChronoUnit.DAYS.between(startOfYear, currentDate);
        System.out.println(daysSinceStartOfYear);
    }
}
