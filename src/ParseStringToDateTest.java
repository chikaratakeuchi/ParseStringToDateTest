import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

public class ParseStringToDateTest {
	private static final String DATE_PATTERN= "yyyy年MM月dd日";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> strList = new ArrayList<String>();
		strList.add("2016年1月13日");
		strList.add("2016年1月14日");
		strList.add("2016年1月15日");
		strList.add("2016年1月16日");
		
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);
		sdf.setLenient(false);
		
		ArrayList<Date> dateList = new ArrayList<Date>();
		
		try{
			for(String str: strList) {
				dateList.add(sdf.parse(str));
			}
		}catch(ParseException e){
			e.printStackTrace();
		}
		
		for(Date date: dateList) {
			if(isYesterday(date)) {
				System.out.println(sdf.format(date));
			}
		}
	}

	// 引数で渡した日付が昨日かを判定する。
	private static boolean isYesterday(Date date){
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, -1);
		Date yesterday = cal.getTime();
		yesterday = DateUtils.truncate(yesterday, Calendar.DAY_OF_MONTH);
		
		if(date.compareTo(yesterday) == 0) {
			return true;
		}else{
			return false;
		}
	}
	
}
