package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
public class txt2{
	public static void main(String[] args) throws Exception
	{   
		File file = new File("E:\\研\\ENGl.txt");//导入txt文档
		@SuppressWarnings("resource")
		FileReader reader = new FileReader(file);
		int fileLen = (int)file.length();
		char[] chars = new char[fileLen];
		reader.read(chars);
		String txt = String.valueOf(chars);
		String[] a=txt.split("[^a-zA-Z]+");   //利用正则表达式将字符串划分为单词字符串数组
		int n=a.length;//获取文章中单词个数
		int nind=0,wind=0;  //nind表示文章中的不同单词个数，初始值为0，wind代表文章中总的单词数
		Object[][] b=new Object[n][2];
		for(;wind<n;wind++){
			int k=0; //用k标记单词是否已经出现,单词已经出现，在已存数组中匹配，若匹配则相应单词数目加1
			for(int i=0;i<nind;i++){
				if(((String) b[i][0]).equalsIgnoreCase(a[wind])){
					b[i][1]=(int)b[i][1]+1;
					k=1;
					break;
				}
			}
			//单词未出现则在记录数组末尾记录此单词
			if(k==0){
				b[nind][0]=a[wind];
				b[nind][1]=1;
				nind++;
			} 
		}
		@SuppressWarnings("resource")
		BufferedReader br1=new BufferedReader(new FileReader("E:\\研\\particle.txt"));//字符输入流 从文件读
		String str=br1.readLine();
		String[] arg=str.split("[^a-zA-Z]+");   //利用正则表达式将字符串划分为单词字符串数组
		int m=arg.length;
		//判断文章中词语是否为虚词，如果为虚词则在比较频率时不计较在内
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
			System.out.println(b[max][0]+"出现次数为:"+b[max][1]);
			b[max][1]=0;
		}
	}
}
