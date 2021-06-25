package com.example.experiment_5_view_and_edit_contact;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.ContentUris;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity { Button view,edit;
    EditText num; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); view=(Button)findViewById(R.id.button); edit=(Button)findViewById(R.id.button2); num=(EditText)findViewById(R.id.editText); view.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { Intent read1=new Intent();
            read1.setAction(android.content.Intent.ACTION_VIEW); read1.setData(ContactsContract.Contacts.CONTENT_URI);
            startActivity(read1);
        }
        });
        edit.setOnClickListener(new View.OnClickListener() { @Override
        public void onClick(View view) { EditContact(num.getText().toString());

        }
        });
    }
    private void EditContact(String contactNumber) { Uri lookupUri =
            Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(contactNumber));
        Cursor mcursor = getContentResolver().query(lookupUri, null, null, null, null);
        long idPhone = 0; try {
            if (mcursor != null) {
                if (mcursor.moveToFirst()) { idPhone =
                        Long.valueOf(mcursor.getString(mcursor.getColumnIndex(ContactsContract. PhoneLookup._ID)));
                    Intent editContact = new Intent(Intent.ACTION_EDIT); editContact.setData(ContentUris.withAppendedId(ContactsContract.Contacts. CONTENT_URI, idPhone));
                    startActivity(editContact);
                } else
                    Toast.makeText(MainActivity.this, "Contact not found", Toast.LENGTH_SHORT).show();
            }
        } finally { mcursor.close();
        }
    }
}
