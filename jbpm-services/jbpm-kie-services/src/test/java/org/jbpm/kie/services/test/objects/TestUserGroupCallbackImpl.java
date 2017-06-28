/*
 * Copyright 2017 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jbpm.kie.services.test.objects;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.kie.api.task.UserGroupCallback;

public class TestUserGroupCallbackImpl implements UserGroupCallback {

    private static Map<String, List<String>> userGroupMap;

    static {
        userGroupMap = new HashMap<>();
        userGroupMap.put("maciej", Arrays.asList("admins"));
        userGroupMap.put("tihomir", Arrays.asList("supplier"));
        userGroupMap.put("kris", Arrays.asList("admins", "managers"));
        userGroupMap.put("Administrator", Arrays.asList("Administrators"));
    }

    @Override
    public boolean existsUser(String user) {
        return userGroupMap.containsKey(user);
    }

    @Override
    public boolean existsGroup(String group) {
        for (String key : userGroupMap.keySet()) {
            if(userGroupMap.get(key).contains(group)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> getGroupsForUser(String user, List<String> groups, List<String> groups2) {
        return userGroupMap.get(user);
    }
}
