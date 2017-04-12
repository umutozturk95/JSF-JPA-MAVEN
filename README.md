# JSF-PRIMEFACES-JPA-MAVEN
 ##Adres Kayıt Uygulaması

 Öncelikle projeden bahsetmek isterim, sistemde bilgisi gömülü olan bir adet "admin" bulunmaktadır.
 Adminin username'i "admin1" password ise "123" şeklindedir.Bu bilgileri kullanarak sisteme giriş yapabilir
 ve sonrasında  adres kayıdı  ekleme,silme ve güncelleme işlemlerini yapabilirsiniz.
 
 Projenin  kodlanması ve geliştirilmesi kısmında ise JSF,JPA,PRIMEFACES ve MAVEN kullanılmıştır.
 Geliştirme ortamları olarak ise Eclipse ve Apache Tomcat kullanılmıştır.Öncelikle IDE konusunda çok kararsız kaldım. Netbeans  ve Eclipse IDE arasında kaldım diyebilirim.Daha çok sektörde Eclipse IDE  kullanılması sebebiyle tercihim Eclipse IDE oldu.Ama ana sebebi ; Netbeans'de JSF için hazır template/şablonlar sunulduğunu unutmamak  gerekir ayrıca bazı sihirbazlar sayesinde çok fazla kod yazmadan uygulama geliştirilebiliyor.Fakat bu durum genelde öğrenme konusunda sıkıntı çıkaracağını düşünüdüğüm için ve hazıra kaçacağını düşünüdüğüm için Netbeans IDE'yi  tercih etmedim.
 
 Veritabanı olarak ise Mysql kullandım ve tabloları daha rahat görmek için Navicat kullandım.Oracle kullanmadım çünkü Oracle SQL Developer kullandım ve çok sorunla karşılaşmıştım.Sorunsuz ve rahat bir ortam sağlayacaktır düşüncesiyle Mysql ve Navicat kullandım.
 
 Tasarım konusunda ise Html ve CSS  ile çok uğraşmak istemedim.Bunun yerine JSF ile beraber kullanılan ve çok popüler olan Primefaces kullanmayı tercih ettim.Hem daha rahat kod yazılıyor hem de görüntü olarak göze daha güzel geliyor.
 
Uygulama sunucusu olarak Apache Tomcat kullandım.Bunun nedeni ise sektörde çok kullanılması ve diğer rakiplerine göre daha iyi olduğunu öğrenmemdir.

## Kurulum
Uygulamayı kurmak için yapılması gerekenler şöyle;

1-Eclipse IDE Java EE sürümü yüklenmelidir.Farklı isimleri var(Kepler,Mars vs...) fakat hepsi aynı işi yapıyor.

2-Apache Tomcat 7,8,9 sürümlerinden biri indirilip kurulmalıdır.Bu proje Apache Tomcat 8 ile geliştirildi.

3-Mysql en son sürümünü indiriniz.Ayrıca Navicat'in de en son sürümünü indirmeyi unutmayınız.Ama Navicat şart değil,Mysql Workbench olması da sorun yaratmayacaktır.Bu kısımda en önemli nokta Mysql'in kurulmasıdır.

4-Baştaki 3 adımı uyguladıktan sonra sistemsel olarak sorun olmayacaktır.Kodu github hesabımdan indirdikten sonra ;
"Eclipse IDE->File->Import-> Existing Projects into Workspace" sekmelerine basıp "browse" ile de indirilen projeyi seçip ,projeyi     Eclipse'ye dahil edin.
 
 5-Projenin classpath içinde  "hibernate.cfg.xml" adında  bir adet  dosya bulunmaktadır.Muhtelemen bu dosya sebebiyle uygulama çalışmayacaktır.Bu yüzden şu kod segmentlerini  değiştirelim;
 
 ```xml
  <property name="hibernate.connection.url">
        jdbc:mysql://localhost:3306/tutorial
   </property>
```
Kurduğunuz Mysql'de "tutorial" isminde bir bağlantı oluşturmanız gerekiyor.Tabiki bu adı değiştirip kendi yarattığınız bir bağlantı adresini verebilirsiniz. Ayrıca sizin Mysql kurulumu sırasında belirlediğiniz kullanıcı adı ve şifre de farklı olacaktır.Aşağıdaki kod satırlarına kendi kullanıcı adı ve şifrelerinizi yazınız;

 ```xml
   <property name="hibernate.connection.username">
        root
   </property>
   <property name="hibernate.connection.password">
       umut
   </property>
```
Bu anlatıklarım başarıyla yapılmış ise uygulama düzgün çalışacaktır.

İyi günler dilerim.

 


 
