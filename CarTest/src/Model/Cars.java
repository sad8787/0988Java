package Model;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
public class Cars {
    private ArrayList<Car> cars=new ArrayList<>();

    public Cars(String FILENAME){
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        ArrayList<Car> carsTemp=new ArrayList<>();
        try {
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();
            NodeList list = doc.getElementsByTagName("Car");
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    // get text data
                    String dataString=element.getElementsByTagName("Date").item(0).getTextContent();
                    Date Date=DataCheque(dataString);
                    if(Date==null){throw new RuntimeException("The date format is not correct");}
                    String BrandName = element.getElementsByTagName("BrandName").item(0).getTextContent();
                    int Price = Integer.parseInt(element.getElementsByTagName("Price").item(0).getTextContent());
                    if(BrandName==""||Price<=0 )
                    {
                        throw new RuntimeException("values must be positive");

                    }
                    carsTemp.add(new Car(Date,BrandName,Price));

                }
            }
            if(carsTemp.size()==list.getLength()){cars=carsTemp;}
        }
        catch (ParserConfigurationException|RuntimeException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<Car> getCars(){
        return cars;
    }
    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }
    public int RecordsCount(){
        return cars.size();
    }
    private Date DataCheque(String dateString){
        Date Date=null;
        try {
            dateString=dateString.replace("/", "&");
            dateString=dateString.replace("-", "&");
            dateString=dateString.replace(".", "&");
            String[] dateCheque = dateString.split("&");

            if(dateCheque.length==3)
            {
                int dd= Integer.parseInt(dateCheque[0]);
                int mm=Integer.parseInt(dateCheque[1]);
                if (mm>12||mm<1){ throw new RuntimeException("The month format is not correct");}
                if (dd<1||dd>31){ throw new RuntimeException("The day format is not correct");}
                if(dd>29 && mm==2){ throw new RuntimeException("The day format is not correct");}
                if(dd>30 && (mm==11 ||mm==4 ||mm==6 ||mm==9 )){ throw new RuntimeException("The day format is not correct");}
                if(dateCheque[2].length()!=4||Integer.parseInt(dateCheque[2])<=0){ throw new RuntimeException("The year format is not correct");}
                dateString=dateString.replace("&", ".");
                Date=new SimpleDateFormat("dd.MM.yyyy").parse(dateString);
            }
            else
            {
                throw new RuntimeException("The date format is not correct");
            }

        }
        catch(RuntimeException |ParseException  e) {
            e.printStackTrace();
        }
        return Date;    }
}

