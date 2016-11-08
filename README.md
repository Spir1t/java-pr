WikiXtractor Dokumentation (v1.0)
---------------------


 * Autoren
 * Ausfuehrung
 * Logging
 * Ergebnisdatei
 * Bugs


AUTOREN
---------------------

 Projekt Contributors und Aufgabe Verteilung:

 MILESTONE #1

     Dinu Ganea
       - Projekt Architektur
       - Build mit Gradle (Dependency Manager & JAR Task)
       - Logging Interface
       - PageFactory

     Ionut Urs
       - LinkExtraction
       - JSOUP Implementierung

     Sonia Rooshenas
       - PageExport
       - Erzeugen der XML Datei mit DOM

     Delara Nasri
       - Page
       - Ueberschreiben von equals, hashCode, toString Methoden





ANWENDUNG
---------------------

 Die JAR Datei wird ueber die Konsole ausgefuerht mit dem folgenden Befehl:

 java -Xmx2g -jar WikiXtractor-1.0.jar input_file output_file

 input_file - absoluter oder relativer Pfad zu der Quelldatei
 output_file - absoluter order relative Pfad wo der Ouput Datei erzeugt wird (Es kann zu einer Exception fuehren, wenn wikiXtractor keine Schreibrechte hat)

 Beispiele:

   - java -Xmx2g -jar WikiXtractor-1.0.jar /home/user/files/wikipedia.txt pages.xml
   - java -Xmx2g -jar WikiXtractor-1.0.jar ../files/wikipedia.txt wikiXtractor/pages.xml
   - java -Xmx2g -jar WikiXtractor-1.0.jar in.txt out.txt




LOGGING
---------------------

 Exceptions und Meldungen ueber den Programmfortschritt werden sowohl in der Konsole als auch in die wikiXtractor/wikiXtractor.log
 Datei geloggt. Der Log Level ist auf debug gesetzt.




ERGEBNISDATEI
---------------------

 Der Pfad zur Ergebnisdatei und/oder der Dateiname wird mit dem ouput_file Parameter spezifiziert (siehe *ANWENDUNG).




BUGS
---------------------

 Es gibt noch keine bekannte Bugs!








