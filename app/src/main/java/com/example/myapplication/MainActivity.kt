public class FormActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText emailEditText;
    private EditText descriptionEditText;
    private DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        // Initialize views
        nameEditText = findViewById(R.id.name_edit_text);
        phoneEditText = findViewById(R.id.phone_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        descriptionEditText = findViewById(R.id.description_edit_text);
        datePicker = findViewById(R.id.date_picker);
s
        // Set up TextInputLayout for EditText views
        TextInputLayout nameTextInputLayout = findViewById(R.id.name_text_input_layout);
        nameTextInputLayout.setHint(getResources().getString(R.string.name_hint));

        TextInputLayout phoneTextInputLayout = findViewById(R.id.phone_text_input_layout);
        phoneTextInputLayout.setHint(getResources().getString(R.string.phone_hint));

        TextInputLayout emailTextInputLayout = findViewById(R.id.email_text_input_layout);
        emailTextInputLayout.setHint(getResources().getString(R.string.email_hint));

        TextInputLayout descriptionTextInputLayout = findViewById(R.id.description_text_input_layout);
        descriptionTextInputLayout.setHint(getResources().getString(R.string.description_hint));

        // Set up "Next" button
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get data from views
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();
                String description = descriptionEditText.getText().toString();

                // Get date from DatePicker
                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();
                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);
                Date dateOfBirth = calendar.getTime();

                // Start Activity2
                Intent intent = new Intent(FormActivity.this, ConfirmationActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("phone", phone);
                intent.putExtra("email", email);
                intent.putExtra("description", description);
                intent.putExtra("dateOfBirth", dateOfBirth);
                startActivity(intent);
            }
        });
    }
}
}