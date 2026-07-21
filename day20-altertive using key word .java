class Solution {
public:
    vector<string> alertNames(vector<string>& keyName, vector<string>& keyTime) {
        unordered_map<string, vector<int>> mp;

        // Convert time HH:MM into minutes and store by name
        for (int i = 0; i < keyName.size(); i++) {
            int hour = stoi(keyTime[i].substr(0, 2));
            int minute = stoi(keyTime[i].substr(3, 2));
            int totalMinutes = hour * 60 + minute;

            mp[keyName[i]].push_back(totalMinutes);
        }

        vector<string> ans;

        // Check each worker
        for (auto &entry : mp) {
            string name = entry.first;
            vector<int> times = entry.second;

            sort(times.begin(), times.end());

            // Check if any 3 uses happen within 60 minutes
            for (int i = 0; i + 2 < times.size(); i++) {
                if (times[i + 2] - times[i] <= 60) {
                    ans.push_back(name);
                    break;
                }
            }
        }

        // Alphabetical order
        sort(ans.begin(), ans.end());

        return ans;
    }
};
