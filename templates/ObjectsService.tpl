/**
 * Service manager to query the $(object_xml) API resource
 * @author everwin-team
 */
public class $(services_class) extends BasicService {

    protected static final Logger LOGGER = LogManager.getLogger();

    public $(services_class)(ClientApi client){
        super(client, "$(services_path)");
    }

    /**
     * Get a $(services_objects) collection<br>
     * Parameter params contains extra informations to sort, filter and load $(services_objects).
     * @param params RequestParams
     * @return $(list_class)
     * @throws CoreException
     */
    public $(list_class) get$(services_method)List(RequestParams params) throws CoreException {
        return ($(list_class)) get($(list_class).class, params);
    }

    /**
     * Get a $(services_objects) collection according to the given url
     * @param href
     * @return $(list_class)
     * @throws CoreException
     */
    public $(list_class) get$(services_method)List(String href) throws CoreException {
        return ($(list_class)) get(href, $(list_class).class, null);
    }

    /**
     * Get a $(services_objects) collection
     * @return $(list_class)
     * @throws CoreException
     */
    public $(list_class) get$(services_method)List() throws CoreException {
        return ($(list_class)) get($(list_class).class, null);
    }

    /**
     * Get the $(services_object) according to the given id
     * @param id
     * @return $(object_class)
     * @throws CoreException
     */
    public $(object_class) get$(services_method)(long id) throws CoreException  {
        return ($(object_class))get(id, $(object_class).class);
    }

    /**
     * Get a $(services_object) according to its href link
     * @param id
     * @return $(object_class)
     * @throws CoreException
     */
    public $(object_class) get$(services_method)(String href) throws CoreException {
        return ($(object_class)) get(href, $(object_class).class);
    }

    /**
     * Delete the $(services_object) identified by the given id and return the status code
     * @param id
     * @throws CoreException
     */
    public void delete$(services_method)(long id) throws CoreException {
        delete(id);
    }

    /**
     * Create a $(services_object) and return the new id
     * @param $(services_object)
     * @return long
     * @throws CoreException
     */
    public long create$(services_method)($(object_class) $(services_object)) throws CoreException {
        return post($(services_object));
    }

    /**
     * Update a $(services_object) according to its id. The whole account will be updated and need to be complete
     * @param $(services_object)
     * @throws CoreException
     */
    public void update$(services_method)($(object_class) $(services_object)) throws CoreException {
        put($(services_object));
    }

    /**
     * Update a $(services_object) according to its id. Only present fields in the given object will be updated.
     * @param $(services_object)
     * @throws CoreException
     */
    public void updatePartially$(services_method)($(object_class) $(services_object)) throws CoreException {
        post(path + "/" + $(services_object).getId(), $(services_object));
    }

}
