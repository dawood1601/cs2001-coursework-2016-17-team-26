package com.example.dawoo.gallery;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.dawoo.gallery.R;

public class MainActivity extends Activity {

    private static int LoadImage = 1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Button buttonLoadImage = (Button) findViewById(R.id.buttonLoadPicture);
        buttonLoadImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, LoadImage);
            }
        });
    }


    @Override
    protected void onActivityResult(int Code_req, int ExcResult, Intent Mydata) {
        super.onActivityResult(Code_req , ExcResult, Mydata);

        if (Code_req == LoadImage && ExcResult == RESULT_OK && null != Mydata) {
            Uri selectedImage = Mydata.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            ImageView View_Image = (ImageView) findViewById(R.id.imgView);
            View_Image.setImageURI(selectedImage);
        }

        
        
        

    }
}
