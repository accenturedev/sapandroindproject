package com.sap.applicationnorthwind.repository;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.sap.cloud.android.odata.demoservice.DemoService;
import com.sap.cloud.android.odata.demoservice.DemoServiceMetadata.EntitySets;

import com.sap.cloud.android.odata.demoservice.Category;
import com.sap.cloud.android.odata.demoservice.Product;
import com.sap.cloud.android.odata.demoservice.Supplier;

import com.sap.cloud.mobile.odata.EntitySet;
import com.sap.cloud.mobile.odata.Property;
import com.sap.applicationnorthwind.service.OfflineWorkerUtil;

import java.util.WeakHashMap;

/*
 * Repository factory to construct repository for an entity set
 */
public class RepositoryFactory {

    /*
     * Cache all repositories created to avoid reconstruction and keeping the entities of entity set
     * maintained by each repository in memory. Use a weak hash map to allow recovery in low memory
     * conditions
     */
    private WeakHashMap<String, Repository> repositories;
    /**
     * Construct a RepositoryFactory instance. There should only be one repository factory and used
     * throughout the life of the application to avoid caching entities multiple times.
     */
    public RepositoryFactory() {
        repositories = new WeakHashMap<>();
    }

    /**
     * Construct or return an existing repository for the specified entity set
     * @param entitySet - entity set for which the repository is to be returned
     * @param orderByProperty - if specified, collection will be sorted ascending with this property
     * @return a repository for the entity set
     */
    public Repository getRepository(@NonNull EntitySet entitySet, @Nullable Property orderByProperty) {
        DemoService demoService = OfflineWorkerUtil.getDemoService();
        String key = entitySet.getLocalName();
        Repository repository = repositories.get(key);
        if (repository == null) {
            if (key.equals(EntitySets.categories.getLocalName())) {
                repository = new Repository<Category>(demoService, EntitySets.categories, orderByProperty);
            } else if (key.equals(EntitySets.products.getLocalName())) {
                repository = new Repository<Product>(demoService, EntitySets.products, orderByProperty);
            } else if (key.equals(EntitySets.suppliers.getLocalName())) {
                repository = new Repository<Supplier>(demoService, EntitySets.suppliers, orderByProperty);
            } else {
                throw new AssertionError("Fatal error, entity set[" + key + "] missing in generated code");
            }
            repositories.put(key, repository);
        }
        return repository;
    }

    /**
     * Get rid of all cached repositories
     */
    public void reset() {
        repositories.clear();
    }
 }
