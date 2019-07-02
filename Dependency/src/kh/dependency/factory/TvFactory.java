package kh.dependency.factory;
import kh.dependency.Items.LgTv;
import kh.dependency.Items.SamsungTv;
import kh.dependency.interfaces.Tv;

public class TvFactory {
public static Tv getInstance(String brand) {
	
	if(brand.equals("lg"))
	{
		return new LgTv();
		}
	else if(brand.equals("samsung"))
	{
		return new SamsungTv();
	}
	return null;
}
}
