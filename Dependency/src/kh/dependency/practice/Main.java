package kh.dependency.practice;

import kh.dependency.Items.LgTv;
import kh.dependency.Items.SamsungTv;
import kh.dependency.factory.TvFactory;
import kh.dependency.interfaces.Tv;

public class Main {
public static void main(String[] args) {
/*args : ���α׷��� �Բ� ����Ǵ� �ż���μ� mail�� call�ϴ� ��찡 ������ 
	     ���ο��� �ѱ�� ���ڰ��� ���α׷��� �����Ű�� ��� �ѱ�� */
		
	Tv tv=TvFactory.getInstance(args[0]);

}
}
