SalesArt Reporter ürünü MVC mimarisi, özel veri modeli ve sanal DOM ile TypeScript kullanılarak yazılmış modern bir
zengin metin (rich-text) editörüdür.
Modern paketleyiciler (bundler) için mükemmel destek sunar.

Hayal edilebilecek her türden WYSIWYG (ne görüyorsan onu alırsın) düzenleme çözümünü sağlar ve kapsamlı iş birliği (
collaboration) desteği sunar.
Aynı zamanda tasarlanan raporların anlık görüntülenmesini sağlamaktadır.

Ürün 2 modülden oluşmaktadır:

* API
* Web

### API Modülü

HTML'den PDF üretimi yapan modüldür.

#### Teknolojiler

Maven yapılandırma aracı kullanılarak Java 17 versiyonu ile geliştirilmiştir.
Uygulama Spring Boot ile geliştirilip içerisindeki Tomcat'le çalıştırılmaktadır.
HTML'de bulunan döngüsel veya parametrik alanların HTML standardına dönüştürülmesi
için [Freemarker](https://github.com/apache/freemarker) kütüphanesi kullanılmıştır.
HTML'den PDF üretimi için [iText](https://github.com/itext) kütüphanesi kullanılmıştır.
Ek olarak açık kaynaklı bir çok teknolojiden yararlanılmıştır. (pom.xml içerisinden incelenebilir.)

Modülde [Layered Pattern](https://www.baeldung.com/cs/layered-architecture) yapısı uygulanmıştır.

* **Sunum Katmanı (Presentation Layer) :**
  İstemci istekleri controller paketi altında bulunan rest uçları ile karşılanmaktadır.
  İsteğin yapısı ve verisi(DTO -> Data Transfer Object) doğrulanarak servislere yönlendirilmektedir.
  Aynı zamanda gönderilen paketin büyüklük kontrolüde burada yapılmaktadır.
  [Swagger UI](http://localhost:8080/swagger-ui/index.html) ile rest uçlarına ve dökümanlarına erişebilirsiniz.

* **Uygulama/İş Mantığı Katmanı (Application/Business Layer) :**
  Servislerin (service), dönüştürücülerin (transformer) ve üreticilerin (generator) bulunduğu paketler bu katmanı ifade
  etmektedir.
  Rest uçlarından gelen istekler önce servis katmanında karşılanır.
  İlk olarak dönüştürücü (transformer) sınıfları ile HTML içerisinde
  bulunan [Freemarker](https://freemarker.apache.org/index.html) özel alanlar HTML standardına çevrilir.
  Bu dönüşüm sırasında istemciden gelen parametreler ve veriler kullanılır.
  Üretici (generator) sınıfları ile düzenlenen HTML içeriği kullanılarak PDF oluşturulur.