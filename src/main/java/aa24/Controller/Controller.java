package aa24.Controller;

import aa24.Model.Model;
import aa24.View.View;

public class Controller implements Comunicable {

    private View view;
    private Model model;

    public Controller(View view) {
        this.view = view;
    }

    @Override
    public void comunicate(Object... data) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'comunicate'");
    }
    
}
