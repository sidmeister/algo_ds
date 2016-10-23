package challenges.twitter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by srathi on 10/22/16.
 */
public class LogProcessing {
        public static void main(String[] args) throws Exception {
            Map<String, Double> all_Req = new TreeMap<>();
            Map<String, Double> non500_requests = new TreeMap<>();
            String line;
            try (InputStreamReader instream = new InputStreamReader(System.in);
                 BufferedReader buffer = new BufferedReader(instream)) {
                while ((line = buffer.readLine()) != null) {
                    String pattern = ".*\\[(.*)]\\s.*?(\\/.+)(\\.[a-z]+).*?\\\"\\s(\\d{3}).*";
                    Pattern r = Pattern.compile(pattern);
                    SimpleDateFormat df = new SimpleDateFormat("dd/MMMM/yyyy:hh:mm:ss", Locale.US);
                    df.setTimeZone(TimeZone.getTimeZone("GMT"));
                    Date result;
                    // Now create matcher object.
                    Matcher m = r.matcher(line);
                    if (m.find()) {
                        result = df.parse(m.group(1));
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
                        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
                        String log_time = sdf.format(result);
                        String extension = m.group(3);
                        Integer http_status = Integer.parseInt(m.group(4));
                        String endpoint = m.group(2);
                        if (all_Req.containsKey(log_time + "_" + endpoint +  extension)) {
                            double count = all_Req.get(log_time + "_" + endpoint +  extension);
                            all_Req.put(log_time + "_" + endpoint + extension, ++count);
                        } else all_Req.put(log_time + "_" + endpoint  + extension, new Double(1));
                        if (!new Integer("500").equals(http_status)) {
                            if (non500_requests.containsKey(log_time + "_" + endpoint  + extension)) {
                                double count = non500_requests.get(log_time + "_" + endpoint  + extension);
                                non500_requests.put(log_time + "_" + endpoint + extension, ++count);
                            } else non500_requests.put(log_time + "_" + endpoint +  extension, new Double(1));
                        }
                    } else System.out.println("NO MATCH");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }

            Iterator it = all_Req.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry pair = (Map.Entry) it.next();
                double total_cnt = (Double) pair.getValue();
                double total_non500_cnt;
                if (non500_requests.containsKey(pair.getKey()))
                    total_non500_cnt = non500_requests.get(pair.getKey());
                else
                    total_non500_cnt = 0;
                double pct= Math.floor((total_non500_cnt / total_cnt * 100*100))/100;
                System.out.println(pct);
                System.out.printf(pair.getKey().toString().replace("_", " ") + " " + "%.2f", pct);
                System.out.print("\n");
                it.remove(); // avoids a ConcurrentModificationException
            }

        }

}
