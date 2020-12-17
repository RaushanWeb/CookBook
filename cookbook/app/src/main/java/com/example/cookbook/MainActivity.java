package com.example.cookbook;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class MainActivity extends AppCompatActivity
{
    int image[] = {R.drawable.american,R.drawable.indian,R.drawable.chinese,R.drawable.arabian,R.drawable.italian,R.drawable.asian};

    static HashMap<String,ArrayList<FoodItem>> hashMap = new HashMap<>();

    ArrayList<FoodItem> IndianList  = new ArrayList<>();
    ArrayList<FoodItem> chineseList = new ArrayList<>();
    ArrayList<FoodItem> americanList = new ArrayList<>();
    ArrayList<FoodItem> italianList = new ArrayList<>();
    ArrayList<FoodItem> arabianList = new ArrayList<>();
    ArrayList<FoodItem> asainList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listitem();

        hashMap.put("Indian",IndianList);
        hashMap.put("Chinese",chineseList);
        hashMap.put("American",americanList);
        hashMap.put("Italian",italianList);
        hashMap.put("Arabian",arabianList);
        hashMap.put("Asian",asainList);

        Set s = hashMap.keySet();
        int n = s.size();
        String arr[] =   new String[n];
        arr = (String[]) s.toArray(arr);
        Arrays.toString(arr);

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ProgrammingAdapter(this,arr,image));


    }

    public void  listitem()
    {
        IndianList.add(new FoodItem("Murg Makhani (Butter Chicken)",R.drawable.indian1));
        IndianList.add(new FoodItem("Instant Pot Butter Chicken",R.drawable.indian2));
        IndianList.add(new FoodItem("Tandoori Chicken",R.drawable.indian3));
        IndianList.add(new FoodItem("Chicken Tikka Masala",R.drawable.indian4));
        IndianList.add(new FoodItem("Malai Kofta",R.drawable.indian5));
        IndianList.add(new FoodItem("Chole (Chickpea Curry)",R.drawable.indian6));

        chineseList.add(new FoodItem("Chinese pork mince stir-fry",R.drawable.chinese1));
        chineseList.add(new FoodItem("Chop suey chow mein",R.drawable.chinese2));
        chineseList.add(new FoodItem("Honey Chicken",R.drawable.chinese3));
        chineseList.add(new FoodItem("Kung Pao Chicken",R.drawable.chinese4));
        chineseList.add(new FoodItem("Prawn Spring Rolls",R.drawable.chinese5));
        chineseList.add(new FoodItem("Simple sweet and sour chicken",R.drawable.chinese6));

        americanList.add(new FoodItem("Ultimate grilled reuben sandwich",R.drawable.ame1));
        americanList.add(new FoodItem("Hot dogs with mustard slaw",R.drawable.ame2));
        americanList.add(new FoodItem("Californian-style baja shrimp",R.drawable.ame3));
        americanList.add(new FoodItem("Fall-apart bourbon ribs",R.drawable.ame4));
        americanList.add(new FoodItem("Viet-Cajun fried prawns",R.drawable.ame5));
        americanList.add(new FoodItem("Pulled pork carnitas",R.drawable.ame6));

        arabianList.add(new FoodItem("Manakeesh",R.drawable.arab1));
        arabianList.add(new FoodItem("Humus",R.drawable.arab2));
        arabianList.add(new FoodItem("Kabsa",R.drawable.arab3));
        arabianList.add(new FoodItem("Matchbous",R.drawable.arab4));
        arabianList.add(new FoodItem("Baklava",R.drawable.arab5));
        arabianList.add(new FoodItem("Falafel",R.drawable.arab6));

        italianList.add(new FoodItem("Panzenella",R.drawable.ital1));
        italianList.add(new FoodItem("Bruschetta",R.drawable.ital2));
        italianList.add(new FoodItem("Focaccia Bread",R.drawable.ital3));
        italianList.add(new FoodItem("Pasta Carbonara",R.drawable.ital4));
        italianList.add(new FoodItem("Margherita Pizza",R.drawable.ital5));
        italianList.add(new FoodItem("Mushroom Risotto",R.drawable.ital6));

        asainList.add(new FoodItem("Steamed bao buns – Taiwan",R.drawable.asi1));
        asainList.add(new FoodItem("Tom yum soup – Thailand",R.drawable.asi2));
        asainList.add(new FoodItem("Prawn laksa – Malaysia",R.drawable.asi3));
        asainList.add(new FoodItem("Easy okonomiyaki – Japan",R.drawable.asi4));
        asainList.add(new FoodItem("Korean fried chicken – Korea",R.drawable.asi5));
        asainList.add(new FoodItem("Rainbow stuffed banh-mi – Vietnam",R.drawable.asi6));

    }

}