package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class txt2{
	public static void main(String[] args) throws Exception
	{   
		File file = new File("E:\\��\\ENGl.txt");//����txt�ĵ�
		@SuppressWarnings("resource")
		FileReader reader = new FileReader(file);
		int fileLen = (int)file.length();
		char[] chars = new char[fileLen];
		reader.read(chars);
		String txt = String.valueOf(chars);
		String[] a=txt.split("[^a-zA-Z]+");   //����������ʽ���ַ�������Ϊ�����ַ�������
		int n=a.length;//��ȡ�����е��ʸ���
		int nind=0,wind=0;  //nind��ʾ�����еĲ�ͬ���ʸ�������ʼֵΪ0��wind�����������ܵĵ�����
		Object[][] b=new Object[n][2];
		for(;wind<n;wind++){
			int k=0; //��k��ǵ����Ƿ��Ѿ�����,�����Ѿ����֣����Ѵ�������ƥ�䣬��ƥ������Ӧ������Ŀ��1
			for(int i=0;i<nind;i++){
				if(((String) b[i][0]).equalsIgnoreCase(a[wind])){
					b[i][1]=(int)b[i][1]+1;
					k=1;
					break;
				}
			}
			//����δ�������ڼ�¼����ĩβ��¼�˵���
			if(k==0){
				b[nind][0]=a[wind];
				b[nind][1]=1;
				nind++;
			} 
		}
		@SuppressWarnings("resource")
		BufferedReader br1=new BufferedReader(new FileReader("E:\\��\\particle.txt"));//�ַ������� ���ļ���
		String str=br1.readLine();
		String[] arg=str.split("[^a-zA-Z]+");   //����������ʽ���ַ�������Ϊ�����ַ�������
		int m=arg.length;
		//�ж������д����Ƿ�Ϊ��ʣ����Ϊ������ڱȽ�Ƶ��ʱ���ƽ�����
		for(int i=0;i<nind;i++){
			for(int j=0;j<m;j++ ){
				if(((String) b[i][0]).equalsIgnoreCase(arg[j])){
					b[i][1]=0;
				}
			}
		}
		for(int i=0;i<10;i++){
			int max=0;
			for(int j=0;j<nind;j++){
				if((int)b[j][1]>(int)b[max][1]){
					max=j;
				}
			}
			System.out.println(b[max][0]+"���ִ���Ϊ:"+b[max][1]);
			b[max][1]=0;
		}
	}
}
