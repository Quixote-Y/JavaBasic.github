package annotationTest;



/*
 * ע���÷�������
 * @Override��������д���ӱ�����棩
 * @Deprecated����ʱ�ˣ����Ƽ�ʹ�ã���������
 * @SuppressWarning �����ƾ�����Ϣ
 */
public class Annotation {
	B a=new B();//���Կ���B������һ�����ߣ������@Deprecated������

}


//@override���
/*
 * 1.@Override����fly���棬��ʾ������дfly����ʱ��д�˸����fly
 * 2.������û��override��ʵû��Ӱ��
 * 3. ����Ҫ�����ã���д��@Override֮�󣬱������ͻ�ȥ���÷����Ƿ������д��
 *   ����ķ���������������ͨ��������������
 * 4.��@Override�Ķ��壺
 * 
 *  @Target(ElementType.METHOD)//����ע���ע�⣺Ԫע��   �������ʾOverride��Ŀ���Ƿ���
    @Retention(RetentionPolicy.SOURCE)
    public @interface Override {
    }
    ����@intrface�����ǽӿڵ���˼�����Ǳ�������һ�� ע����
 */
class Father{
	void fly(){};
}

class Son extends Father{
	@Override
	void fly() {};
}

//@Deprecated���
/*
 * 1.����ĳ��Ԫ�أ���ʾ��Ԫ���Ѿ���ʱ��
 * 2.���Ƽ�ʹ�ã�����Ȼi�ܹ�ʹ��
 * 3.�������η������࣬�ֶΣ����������ȵ�
 * 4.������ϵͳ�����и��õ����Ʒʱ�������Ѳ���
 * 5.�鿴һ��Դ�룺
 *   @Documented
     @Retention(RetentionPolicy.RUNTIME)
     @Target(value={CONSTRUCTOR, FIELD, LOCAL_VARIABLE, METHOD, PACKAGE, MODULE, PARAMETER, TYPE})
     public @interface Deprecated {
 */
//���Կ���B������һ�����ߣ������@Deprecated������
@Deprecated
class B{
	
}

//@DepressWarnings���
/*1.�����ǲ�ϣ������ĳЩ������Ϣʱ������ʹ��DepressWarnings�����ƾ�����Ϣ
 * 2.DepressWarnings{" ���� "}���ݲ����Ĳ�ͬ���Ʋ�ͬ�ľ�����Ϣ��all����������
 * 3.���õ�λ�ò�ͬ��Ч��Ҳ�ᷢ���仯
 * 
*/


//Ԫע�⣺����ע���ע��
/*
 * Retention:ָ����ע�Ᵽ���೤ʱ�䣬
 * �������ͣ�SOURCE����Դ�����.java��CLASS:ֱ��������Ϊclass�ļ���RUNTINE��������
 * 
 * Target������ָ�����ε�ע����Ч����Щλ��
 * 
 * @Documented��
 * @Inherited:
*/