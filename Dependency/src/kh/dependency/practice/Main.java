package kh.dependency.practice;

import kh.dependency.Items.LgTv;
import kh.dependency.Items.SamsungTv;
import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;

public class Main {
public static void main(String[] args) {
/*args : 프로그램과 함께 실행되는 매서드로서 mail은 call하는 경우가 없지만 
	     메인에게 넘기는 인자값은 프로그램을 실행시키는 경우 넘긴다 */
		
	Tv tv=TvFactory.getInstance(args[0]);

}
}
