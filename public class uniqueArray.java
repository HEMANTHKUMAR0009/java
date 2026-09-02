public class uniqueArray
{
    private int[]array;
    private int size;
    java.util.Scanner sc;
    public uniqueArray(int size)
    {
        this.size=size;
        array=new int[size];
        sc=new java.util.scanner("system.in");
    }
    public void readArray()
    {
        int data;
    for(int i=0;i<size;i++)
    {
        system.out.println("enter data:");
        data=sc.nextInt();
        if(search(data))
        {
            system.out.println("duplicate data");
            i--;
            continue;
        }
        array[i]=data;
    }
    }
private boolean search(int data)
{
    for(int i=0;i<size;i++)
    {
        if(array[i]==data)
            return true;
    }
    return false;
}
void displayarray()
{
    for(int i=0;i<size;i++)
    {
        system.out.print(array[i]+" ");
    }
}
public void findmax()
{
    int max=array[0];
    for(int i=1;i<size;i++)
    {
        if(array[i]>max)
            max=array[i];
    }
    System.out.println("max values"+max);
}
public void sumofelements()
{
    int sum=0;
    for(int i=0;i<size;i++)
    {
        sum+=array[i]
    }
    system.out.println("sum of elements:"+sum);
}
public void sortelements()
{
    for(int i=0;i<size-i-1;i++)
    {
        for (int j=0;j<size-i-1;j++)
        {
            if(array[i]>array[j=1])
            {
                int temp=array[j];
                array[j+1]=temp;
            }
        }
    }
}
public static void main(String[] args) 
{
    uniqueArray ua=new uniqueArray(5);
    ua.readArray();
    ua.displayarray();
    ua.findmax();
    ua.sumofelements();
}
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        