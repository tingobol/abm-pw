/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package abmwar;

import beans.ClienteFacadeLocal;
import com.sun.data.provider.RowKey;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.component.Button;
import com.sun.webui.jsf.component.DropDown;
import com.sun.webui.jsf.component.TextField;
import java.util.ArrayList;
import java.util.List;
import javax.faces.FacesException;
import com.sun.webui.jsf.model.Option;
import com.sun.webui.jsf.event.TableSelectPhaseListener;
import com.sun.webui.jsf.component.TableRowGroup;
import entidades.Cliente;
import javax.ejb.EJB;
import javax.faces.component.html.HtmlPanelGrid;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Clientes.java
 * @version Created on Aug 26, 2009, 11:30:46 PM
 * @author markos
 */
public class Clientes extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private Button btnCancelar1 = new Button();

    public Button getBtnCancelar1() {
        return btnCancelar1;
    }

    public void setBtnCancelar1(Button b) {
        this.btnCancelar1 = b;
    }
    private Button btnUpdate = new Button();

    public Button getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(Button b) {
        this.btnUpdate = b;
    }
    private Button btnAceptar = new Button();

    public Button getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(Button b) {
        this.btnAceptar = b;
    }
    private TextField txtRuc = new TextField();

    public TextField getTxtRuc() {
        return txtRuc;
    }

    public void setTxtRuc(TextField tf) {
        this.txtRuc = tf;
    }
    private TextField txtDireccion = new TextField();

    public TextField getTxtDireccion() {
        return txtDireccion;
    }

    public void setTxtDireccion(TextField tf) {
        this.txtDireccion = tf;
    }
    private TextField txtApellido = new TextField();

    public TextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(TextField tf) {
        this.txtApellido = tf;
    }
    private TextField txtCi = new TextField();

    public TextField getTxtCi() {
        return txtCi;
    }

    public void setTxtCi(TextField tf) {
        this.txtCi = tf;
    }
    private TextField txtNombre = new TextField();

    public TextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(TextField tf) {
        this.txtNombre = tf;
    }
    private TextField txtFiltro = new TextField();

    public TextField getTxtFiltro() {
        return txtFiltro;
    }

    public void setTxtFiltro(TextField tf) {
        this.txtFiltro = tf;
    }
    private DropDown dropDownFiltro = new DropDown();

    public DropDown getDropDownFiltro() {
        return dropDownFiltro;
    }

    public void setDropDownFiltro(DropDown dd) {
        this.dropDownFiltro = dd;
    }
    private HtmlPanelGrid gridPanelDown = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelDown() {
        return gridPanelDown;
    }

    public void setGridPanelDown(HtmlPanelGrid hpg) {
        this.gridPanelDown = hpg;
    }
    private HtmlPanelGrid gridPanelForm = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelForm() {
        return gridPanelForm;
    }

    public void setGridPanelForm(HtmlPanelGrid hpg) {
        this.gridPanelForm = hpg;
    }
    private HtmlPanelGrid gridPanelBotones = new HtmlPanelGrid();

    public HtmlPanelGrid getGridPanelBotones() {
        return gridPanelBotones;
    }

    public void setGridPanelBotones(HtmlPanelGrid hpg) {
        this.gridPanelBotones = hpg;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public Clientes() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here

        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Clientes Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
        cargaFiltro();
        if (viewForm) {
            gridPanelForm.setRendered(true);
            gridPanelBotones.setRendered(true);
            if (updating) {
                btnAceptar.setRendered(false);

                try {
                    RowKey rowKey = tableRowGroup.getRowKey();
                    getListaClientes();
                    cliente = listaClientes.get(Integer.parseInt(rowKey.getRowId()));
                    if (cliente != null) {
                        txtNombre.setText(cliente.getNombre());
                        txtDireccion.setText(cliente.getDireccion());
                        txtCi.setText(cliente.getCi());
                        txtApellido.setText(cliente.getApellido());
                        txtRuc.setText(cliente.getRuc());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (inserting) {
                btnUpdate.setRendered(false);
            }
        } else {
            gridPanelForm.setRendered(false);
            gridPanelBotones.setRendered(false);
        }
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String btnBuscar_action() {
        String condicion = "";
        try {
            if (txtFiltro.getText() != null && txtFiltro.getText().toString().length() > 0) {
                String prefix = txtFiltro.getText().toString();
                if (dropDownFiltro.getSelected().toString().equals("0")) {
                    condicion = " where c.codigo = " + prefix;
                } else if (dropDownFiltro.getSelected().toString().equals("1")) {
                    condicion = " where upper(c.nombre) like '%" + prefix.toUpperCase() + "%'";
                }
            }
            listaClientes = clienteFacade.getListaClientes(condicion);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String botonLimpiar_action() {
        txtFiltro.setText("");
        return null;
    }

    public String botonModificar_action() {
        updating = true;
        viewForm = true;
        return null;
    }

    public String botonEliminar_action() {
        try {
            btnBuscar_action();
            RowKey rowKey = tableRowGroup.getRowKey();
            cliente = listaClientes.get(Integer.parseInt(rowKey.getRowId()));
            clienteFacade.remove(cliente);
            info("Registro eliminado con exito!");

        } catch (Exception e) {
            error("Error al eliminar el registro. " + e);
        }
        return null;
    }

    public String botonInsertar1_action() {
        inserting = true;
        viewForm = true;
        return null;
    }

    public String btnAceptar_action() {
        cliente = new Cliente();
        cliente.setNombre(txtNombre.getText().toString());
        cliente.setDireccion(txtDireccion.getText().toString());
        cliente.setCi(txtCi.getText().toString());
        cliente.setApellido(txtApellido.getText().toString());
        cliente.setRuc(txtRuc.getText().toString());
        try {
            clienteFacade.create(cliente);
            viewForm = false;
            info("El registro se ha actualizado con exito!");
        } catch (Exception e) {
            error("Ha ocurrido un error! " + e);
            e.printStackTrace();
        }
        return null;
    }

    public String btnUpdate_action() {

        btnBuscar_action();
        RowKey rowKey = tableRowGroup.getRowKey();
        cliente = listaClientes.get(Integer.parseInt(rowKey.getRowId()));
        cliente.setNombre(txtNombre.getText().toString());
        cliente.setDireccion(txtDireccion.getText().toString());
        cliente.setCi(txtCi.getText().toString());
        cliente.setApellido(txtApellido.getText().toString());
        cliente.setRuc(txtRuc.getText().toString());
        try {
            clienteFacade.edit(cliente);
            viewForm = false;
            info("El registro se ha actualizado con exito!");
        } catch (Exception e) {
            error("Ha ocurrido un error! " + e);
            e.printStackTrace();
        }
        return null;
    }

    public String btnCancelar_action() {
        return null;
    }
    private boolean inserting = false;
    private boolean updating = false;
    private boolean viewForm = false;
    private TableRowGroup tableRowGroup = new TableRowGroup();
    private TableSelectPhaseListener tablePhaseListener =
            new TableSelectPhaseListener();

    public List<Cliente> getListaClientes() {
        btnBuscar_action();
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public TableRowGroup getTableRowGroup() {
        return tableRowGroup;
    }

    public void setTableRowGroup(TableRowGroup tableRowGroup) {
        this.tableRowGroup = tableRowGroup;
    }

    public TableSelectPhaseListener getTablePhaseListener() {
        return tablePhaseListener;
    }

    public void setTablePhaseListener(TableSelectPhaseListener tablePhaseListener) {
        this.tablePhaseListener = tablePhaseListener;
    }

    public void setSelected(Object object) {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        if (rowKey != null) {
            tablePhaseListener.setSelected(rowKey, object);
        }
    }

    public Object getSelected() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.getSelected(rowKey);

    }

    public Object getSelectedValue() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return (rowKey != null) ? rowKey.getRowId() : null;
    }

    public boolean getSelectedState() {
        RowKey rowKey = (RowKey) getValue("#{currentRow.tableRow}");
        return tablePhaseListener.isSelected(rowKey);
    }
    private List<Option> opcionFiltro;

    private void cargaFiltro() {
        opcionFiltro = new ArrayList<Option>();
        opcionFiltro.add(new Option("0", "Codigo"));
        opcionFiltro.add(new Option("1", "Nombre"));
    }

    public List<Option> getOpcionFiltro() {
        return opcionFiltro;
    }

    public void setOpcionFiltro(List<Option> opcionFiltro) {
        this.opcionFiltro = opcionFiltro;
    }
    private List<Cliente> listaClientes;
    private Cliente cliente;
    @EJB
    private ClienteFacadeLocal clienteFacade;
}

