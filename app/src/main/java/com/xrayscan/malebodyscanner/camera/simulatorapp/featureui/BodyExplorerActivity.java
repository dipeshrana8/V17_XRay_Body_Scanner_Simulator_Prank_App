package com.xrayscan.malebodyscanner.camera.simulatorapp.featureui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.GridLayoutManager;

import com.xrayscan.malebodyscanner.camera.simulatorapp.R;
import com.xrayscan.malebodyscanner.camera.simulatorapp.databinding.LytAct11Binding;
import com.xrayscan.malebodyscanner.camera.simulatorapp.entry.AnatomyDataModel;
import com.xrayscan.malebodyscanner.camera.simulatorapp.entry.AnatomyItemAdapter;

import java.util.ArrayList;
import java.util.List;


public class BodyExplorerActivity extends MainBaseActivity {

    LytAct11Binding lytAct11Binding;
    AnatomyItemAdapter anatomyItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        lytAct11Binding = LytAct11Binding.inflate(getLayoutInflater());
        setContentView(lytAct11Binding.getRoot());

        lytAct11Binding.toolbarLayout.headerTitle.setText("Explore Body Part");
        lytAct11Binding.toolbarLayout.btnBack.setOnClickListener(v -> onBackPressed());
        List<AnatomyDataModel> items = getbodyparts();
        anatomyItemAdapter = new AnatomyItemAdapter(items);
        lytAct11Binding.recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        lytAct11Binding.recyclerView.setAdapter(anatomyItemAdapter);

        lytAct11Binding.btnNext.setOnClickListener(v -> {
            AnatomyDataModel selected = anatomyItemAdapter.getSelectedItem();
            if (selected == null) {
                Toast.makeText(this, "Please select a body part", Toast.LENGTH_SHORT).show();
            } else {

                Intent intent = new Intent(this, BodyPartInfoActivity.class);
                intent.putExtra("title", selected.getString());
                intent.putExtra("image", selected.getImageResId());
                intent.putExtra("description", selected.getDescription());
                startActivity(intent);


            }
        });
    }

    private List<AnatomyDataModel> getbodyparts() {
        List<AnatomyDataModel> list = new ArrayList<>();

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_18,
                "Hair",
                "Hair, often considered a crowning glory, is a remarkable biological structure that extends far beyond mere aesthetics. Composed primarily of keratin, it grows from follicles embedded within the skin and serves multiple purposes, including insulation, protection from ultraviolet radiation (especially on the scalp), and sensory input. Culturally and personally, hair plays a profound role in identity, self-expression, and social signaling. Its color, texture, density, and growth patterns are influenced by a complex interplay of genetics, age, hormonal factors, and overall health, making it a unique and dynamic aspect of each individual.\n\n" +
                        "When you engage in observing your hair through this feature, the aim is to cultivate a detailed awareness of its current condition. You'll be prompted to assess its volume and body – does it appear full and lively, or is it flatter and less dense than you prefer? Consider its texture: is it naturally smooth and sleek, wavy, curly, or coily? Note the surface quality – does it feel soft and supple, or rough and dry? Examine its luster and shine, as healthy hair typically reflects light, while dullness can indicate dryness or product buildup. Furthermore, if your scalp is visible, observe its condition for signs of flakiness, redness, or oiliness, as scalp health is intrinsically linked to hair vitality.\n\n" +
                        "By regularly tracking these observable characteristics, you can gain valuable insights into how your hair responds to your chosen care regimen, environmental conditions, and lifestyle factors. For instance, you might notice changes in moisture levels after introducing a new deep conditioner, or observe increased frizz during humid weather. Documenting these shifts can help you identify patterns – perhaps stress correlates with temporary thinning, or a dietary change improves its sheen. This detailed self-assessment empowers you to make more informed decisions about the products you use, the styling techniques you employ, and even potential dietary or lifestyle adjustments that could benefit your hair's health and appearance.\n\n" +
                        "Cultivating this consistent habit of hair observation fosters a proactive approach to personal care, allowing you to address subtle changes before they become more significant concerns. This heightened awareness contributes not only to maintaining the aesthetic appeal of your hair but also to a deeper understanding of your body's signals. Healthy, vibrant hair can significantly boost self-confidence and contribute positively to your overall sense of well-being. By becoming more attuned to its needs, you can ensure your hair remains a beautiful and healthy expression of your individuality."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_14,
                "Eye",
                "The eyes are extraordinary sensory organs, our primary windows to the visual world, enabling us to perceive light, color, depth, and movement. Beyond their critical functional role in navigation, learning, and interaction, eyes are also a central feature of facial expression, conveying a vast spectrum of emotions and facilitating non-verbal communication. The appearance of the eyes – their clarity, brightness, and the condition of the surrounding skin – can often reflect aspects of our overall health, fatigue levels, and even emotional state, making them a focal point of interpersonal connection and self-assessment.\n\n" +
                        "When you direct your attention to your eyes for observation, focus on several key indicators. Note the clarity and whiteness of the sclera (the white part) – does it appear bright and clear, or are there signs of redness, yellowing, or visible blood vessels? Observe the iris for its distinct color and pattern, and the pupil for its responsiveness if you're checking in different light conditions. Examine the surrounding skin carefully: are the eyelids smooth or showing signs of puffiness or drooping? Is the under-eye area smooth, or are there dark circles, fine lines, or bags? Assess the overall impression – do your eyes look alert and rested, or tired and strained?\n\n" +
                        "Consistent observation of these details can provide valuable feedback on your lifestyle and environmental influences. For example, persistent dark circles might prompt you to evaluate your sleep quality or hydration, while increased redness could be linked to screen time, allergies, or environmental irritants. By tracking these visual cues, you can begin to correlate changes in your eye appearance with specific activities, habits, or even dietary choices. This self-awareness can guide you toward beneficial adjustments, such as implementing the 20-20-20 rule for screen use, improving sleep hygiene, or ensuring adequate fluid intake, all of which can contribute to healthier-looking and more comfortable eyes.\n\n" +
                        "A regular practice of mindful eye observation encourages a proactive stance towards the well-being of these vital organs and their aesthetic contribution. While not a substitute for professional ophthalmological care, this habit enhances your ability to notice subtle changes that might warrant further attention or simple lifestyle modifications. Nurturing the health and appearance of your eyes contributes to clearer vision, more expressive communication, and an overall sense of vitality and confidence in your daily interactions."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_15,
                "Eyebrow",
                "Eyebrows, though seemingly simple arches of hair above the eyes, are remarkably influential facial features. They serve a protective function, helping to shield the eyes from sweat, rain, and debris, but their role in communication and aesthetics is perhaps even more significant. Eyebrows are critical in conveying a wide array of non-verbal cues and emotions, from surprise and anger to concentration and empathy. Their shape, thickness, and position can dramatically alter the perceived facial structure, frame the eyes, and contribute to overall facial harmony and symmetry.\n\n" +
                        "When you focus on observing your eyebrows, consider their overall shape and how it complements your facial features – are they naturally arched, straight, curved, or S-shaped? Assess their thickness and density: are they full and well-defined throughout, or do they have areas that are sparser or thinner? Note the length of the brows and where they begin and end in relation to your eyes and nose. Examine the hair texture – are the individual hairs fine, coarse, straight, or curly? Also, observe their color and whether it is consistent, and look for symmetry between the two brows, noting any subtle or significant differences in their shape or fullness.\n\n" +
                        "Tracking the appearance of your eyebrows over time can provide insights into the effectiveness of your grooming routines and how your brows may be changing due to age, hormonal shifts, or even stress. You might notice, for instance, that certain tweezing or waxing patterns lead to a more desirable shape, or that a new brow serum appears to enhance fullness. This mindful observation allows you to make informed choices about shaping, filling, or styling techniques to achieve a look that enhances your natural features and aligns with your personal aesthetic preferences. It can also help you identify any unusual hair loss or skin changes in the brow area that might warrant attention.\n\n" +
                        "Consistent attention to your eyebrows is a valuable component of holistic facial care and self-expression. Well-groomed and appropriately shaped eyebrows can lift the face, open up the eye area, and create a more polished and balanced appearance. By understanding the unique characteristics of your brows and learning how to best care for and style them, you enhance not only your features but also your ability to communicate effectively through subtle expressions. This detailed awareness contributes to overall confidence and a refined personal presentation."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_97,
                "Neck",
                "The neck is a vital and often underappreciated region of the body, serving as a flexible conduit supporting the head and connecting it to the torso. It houses critical structures such as the cervical spine, major blood vessels supplying the brain, the trachea, esophagus, and numerous muscles essential for head movement and posture. Beyond its functional importance, the neck's appearance, including its skin texture, contour, and lines, contributes significantly to one's overall youthful or aged presentation and can reflect postural habits and lifestyle.\n\n" +
                        "When observing your neck, pay attention to several aspects. Assess your neck posture from different angles – does your head sit balanced atop your spine, or is there a forward head tilt, often associated with 'tech neck'? Examine the skin for its tone, texture, and elasticity. Note the presence and depth of any horizontal lines (often called 'necklace lines') or vertical bands, which can be related to aging, sun exposure, or muscle activity. Check for any asymmetries, irregularities in contour, or visible muscle tension, particularly in the trapezius or sternocleidomastoid muscles.\n\n" +
                        "Regularly monitoring your neck's appearance and perceived posture can provide valuable insights into your daily habits and their impact. For instance, increased prominence of neck lines might prompt you to be more diligent with sunscreen application or to consider skincare products specifically formulated for the delicate neck skin. Awareness of a forward head posture can encourage you to adjust your ergonomic setup or incorporate specific stretches and exercises. This self-assessment can help you correlate neck discomfort or stiffness with postural habits during work or leisure activities, leading to proactive adjustments.\n\n" +
                        "Cultivating awareness of your neck fosters a more holistic approach to self-care and body mechanics. By addressing postural imbalances early and caring for the neck skin, you can potentially mitigate issues like chronic neck pain, premature aging signs, and restricted mobility. A well-aligned, supple neck not only contributes to a more graceful and confident appearance but also supports overall musculoskeletal health and comfort in daily life."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_19,
                "Hand",
                "Hands are one of the most complex and expressive parts of the human body, indispensable tools for interaction, creation, and daily tasks. Comprising a sophisticated structure of bones, joints, muscles, nerves, and blood vessels, they allow for an incredible range of motion, dexterity, and sensation. The appearance of our hands, including the skin, nails, and joint contours, can often reflect our age, health status, occupation, and level of care, serving as a subtle but constant form of self-presentation.\n\n" +
                        "When you focus on observing your hands, examine the skin's texture and hydration – does it appear smooth and supple, or dry, rough, or chapped? Note the skin tone and any variations, such as age spots, redness, or prominent veins. Assess the condition of your fingernails: are they strong and smooth, or brittle, ridged, discolored, or showing signs of peeling? Look at the joints in your fingers and wrists, noting their symmetry, any visible swelling, or changes in their usual contour. Consider the overall muscularity and fullness of your hands.\n\n" +
                        "Tracking the condition of your hands can reveal important connections to your daily activities, environmental exposures, and internal well-being. For example, frequent hand washing or exposure to harsh chemicals might lead to dryness or irritation, prompting the use of moisturizers or protective gloves. Changes in nail appearance can sometimes indicate nutritional deficiencies or other health considerations. Observing joint discomfort or swelling might encourage ergonomic adjustments at work or during hobbies. This self-awareness enables you to tailor your hand care routine effectively.\n\n" +
                        "Consistent attention to your hands promotes proactive care that can maintain their functionality and aesthetic appeal throughout life. Regular moisturizing, sun protection, and mindful use can prevent premature aging and discomfort. Being attuned to subtle changes can also lead to earlier recognition of conditions that might benefit from professional advice. Well-cared-for hands not only feel more comfortable and capable but also contribute to a sense of personal grooming and confidence in social and professional interactions."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_107,
                "Tongue",
                "The tongue is a remarkable muscular organ situated in the mouth, playing crucial roles in taste, speech, chewing, and swallowing. Its surface is covered with papillae, many of which contain taste buds, allowing us to experience the diverse flavors of food. In many traditional medicine systems, the tongue is also considered a valuable indicator of overall internal health, with its color, coating, texture, and shape believed to reflect the body's systemic balance or imbalance.\n\n" +
                        "When observing your tongue, note its overall color – a healthy tongue is typically pinkish-red. Look for any significant deviations, such as an excessively pale, bright red, purplish, or yellowish hue. Examine the coating: is there a thin, clear or white coating (which can be normal), or is it thick, patchy, yellow, or dark? Assess the texture of the tongue surface – is it relatively smooth with visible papillae, or does it appear unusually smooth (atrophic), fissured, scalloped (showing indentations from teeth), or geographic (with map-like patches)? Also, note its size and shape relative to your mouth.\n\n" +
                        "Regularly checking your tongue's appearance can provide visual cues that might correlate with dietary habits, hydration levels, oral hygiene, or even stress. For example, a thicker white coating might suggest a need to improve oral hygiene or could be related to certain foods or mild digestive imbalance. Increased redness or soreness could be linked to acidic foods, a vitamin deficiency, or irritation. Observing these changes encourages mindfulness about what you consume and how your body responds, prompting adjustments like increasing water intake or paying more attention to your dental care routine.\n\n" +
                        "While self-observation of the tongue is not a diagnostic tool, it can be a useful component of personal health awareness, prompting you to seek professional advice if you notice persistent or concerning changes. A healthy-looking tongue contributes to fresh breath and comfortable eating and speaking. By incorporating this simple check into your routine, you gain another layer of insight into your body's daily state and foster a proactive approach to maintaining both oral and overall well-being."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_95,
                "Leg",
                "Legs are the foundational pillars of human locomotion, providing support, strength, and mobility. Comprising the body's largest bones and some of its most powerful muscle groups, they enable us to stand, walk, run, jump, and perform countless daily activities. The health and appearance of our legs, from the hips down to the ankles, can reflect our activity levels, circulatory health, and overall physical conditioning, significantly impacting our quality of life and confidence.\n\n" +
                        "When you observe your legs, consider their overall shape and symmetry. Assess muscle tone and definition in the thighs, calves, and hamstrings – do they appear firm and well-proportioned, or are there areas of noticeable weakness or imbalance? Examine the skin for its texture, hydration, and evenness of tone. Look for any signs of swelling, particularly around the ankles or lower legs, visible veins (such as spider veins or varicose veins), bruising, or changes in skin color. Also, note the range of motion and comfort in your hip, knee, and ankle joints as you move.\n\n" +
                        "Tracking the appearance and feel of your legs can provide valuable insights into how your lifestyle choices are affecting them. For instance, increased muscle definition might reflect a new exercise routine, while persistent swelling could prompt you to evaluate factors like prolonged sitting or standing, salt intake, or the need for more movement. Noticing the development of varicose veins might encourage lifestyle adjustments like regular exercise, leg elevation, or wearing compression stockings. This self-awareness can help you make informed decisions to support leg health and comfort.\n\n" +
                        "Consistent attention to your legs promotes proactive care that supports their vital functions and aesthetic appearance. Regular physical activity, maintaining a healthy weight, and proper hydration are key to keeping legs strong and circulation efficient. By being attuned to subtle changes, you can address potential issues early, whether it's adjusting your workout, improving ergonomics, or seeking advice for persistent concerns. Healthy, strong legs are fundamental to an active lifestyle and contribute significantly to overall well-being and a positive body image."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_11,
                "Chest",
                "The chest, or thorax, is a vital region of the upper body that houses and protects critical organs such as the heart and lungs, while also playing a significant role in respiration, posture, and upper body strength. Its structure, formed by the rib cage, sternum, and thoracic spine, provides a sturdy yet flexible framework. Aesthetically, the chest contributes significantly to the body's overall shape and proportion, and its appearance can be influenced by musculature, posture, and skin condition.\n\n" +
                        "When observing your chest, pay attention to its overall symmetry and contour. Assess the development and definition of the pectoral muscles – do they appear balanced and toned according to your fitness goals? Examine the skin for its texture, tone, and any notable features like moles, blemishes, or signs of sun damage, especially in the décolletage area which is often exposed. Note your posture – is your chest open and lifted, or does it tend to be rounded or sunken? Also, be aware of your breathing pattern and whether your chest expands easily and symmetrically during inhalation.\n\n" +
                        "Regularly monitoring your chest's appearance and how it feels can offer insights into your fitness progress, postural habits, and skin health. For example, tracking changes in pectoral muscle definition can be motivating if you're engaged in strength training. Noticing sun damage might encourage better sun protection habits. Awareness of a slumped posture can prompt you to incorporate exercises that strengthen the back and open the chest. This self-assessment can guide you in tailoring your exercise routines, skincare, and daily habits for optimal chest health and appearance.\n\n" +
                        "Cultivating awareness of your chest area is part of a holistic approach to body confidence and well-being. A strong, open chest not only contributes to a more commanding and assured posture but also supports efficient breathing and protects vital organs. By paying attention to its muscular development, skin condition, and alignment, you empower yourself to maintain its health and aesthetics, contributing positively to your overall physical presentation and functional capacity."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_16,
                "Face",
                "The face is arguably the most expressive and individually recognizable part of the human body, serving as the primary canvas for our identity, emotions, and communication. It houses several key sensory organs and is intricately composed of bones, muscles, fat pads, and skin that work in concert to create a vast range of expressions. The appearance of our face – its symmetry, skin quality, features, and contours – is central to social interaction and self-perception, often reflecting our age, health, lifestyle, and emotional state.\n\n" +
                        "When you focus on observing your face, take a comprehensive look. Assess its overall symmetry – are your features relatively balanced on both sides? Examine your skin's complexion: note its tone, texture, clarity, and hydration levels. Look for areas of redness, uneven pigmentation, blemishes, or visible pores. Observe the contours of your face, including the definition of your jawline, cheekbones, and temples. Pay attention to specific features like the fullness of your lips, the shape of your nose, and the area around your eyes, noting any fine lines, wrinkles, or puffiness.\n\n" +
                        "Tracking changes in your facial appearance can provide rich insights into how your skin responds to your care routines, diet, sleep patterns, stress levels, and environmental factors. For instance, you might notice increased radiance after adopting a new skincare product, or observe puffiness after a night of poor sleep or high salt intake. Documenting these shifts helps you identify triggers and beneficial habits, empowering you to make informed decisions about your lifestyle and skincare regimen to promote a healthier, more vibrant complexion and facial appearance.\n\n" +
                        "Consistent facial observation promotes a proactive and personalized approach to skincare and well-being. By understanding your skin's unique needs and how it reacts to various influences, you can tailor your care to maintain its health and youthful vitality. This heightened awareness also fosters self-acceptance and confidence, allowing you to appreciate your unique features while taking positive steps to care for your appearance. A well-cared-for face not only looks good but also reflects inner health and contributes significantly to positive self-esteem."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_17,
                "Foot",
                "Feet are the unsung heroes of our anatomy, complex structures of bones, joints, ligaments, muscles, and tendons that bear our entire body weight and enable locomotion. They provide balance, absorb shock, and adapt to varied terrains, making them crucial for almost every daily activity. The health and condition of our feet, from the arches and toes to the skin and nails, can significantly impact our overall comfort, mobility, and even posture, yet they are often overlooked in self-care routines.\n\n" +
                        "When observing your feet, examine their overall structure and shape. Note the height and integrity of your arches – do they appear well-supported, flat, or unusually high? Assess the alignment of your toes: are they straight, or are there signs of conditions like bunions or hammertoes? Examine the skin on the soles and heels for calluses, corns, cracks, or areas of excessive dryness or moisture. Check your toenails for their color, thickness, and any signs of ingrown nails or fungal infections. Also, be aware of any areas of tenderness, pain, or swelling.\n\n" +
                        "Regularly monitoring your feet can provide important clues about your footwear choices, activity levels, and even systemic health. For example, the development of calluses might indicate pressure points from ill-fitting shoes, while persistent dryness could be related to hydration or skin conditions. Observing changes in nail appearance or unexplained swelling might prompt you to consider underlying factors. This self-awareness empowers you to make better choices regarding shoe selection, foot hygiene, and when to seek professional podiatric care.\n\n" +
                        "Cultivating consistent attention to your feet is fundamental for maintaining long-term mobility, comfort, and overall well-being. Proper foot care, including wearing appropriate footwear, regular cleaning and moisturizing, and addressing minor issues promptly, can prevent many common foot problems. Healthy, comfortable feet allow you to stay active, support good posture, and contribute significantly to your daily quality of life, enabling you to move through the world with greater ease and confidence."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_98,
                "Nose",
                "The nose, prominently positioned in the center of the face, serves vital respiratory functions as the primary passageway for air entering the lungs, where it is warmed, humidified, and filtered. It also houses the olfactory receptors responsible for our sense of smell, which plays a key role in taste perception, hazard detection, and memory. Aesthetically, the nose is a defining facial feature, significantly influencing facial symmetry, profile, and overall harmony.\n\n" +
                        "When you observe your nose, consider its external shape and symmetry. Note the bridge – is it straight, curved, or bumped? Examine the tip for its shape, projection, and any asymmetries. Observe the nostrils: their size, shape, and whether they appear symmetrical. Assess the skin on and around your nose for its texture, pore size, oiliness, or dryness. Look for any redness, blackheads, visible capillaries, or other skin conditions common to this area. Also, be mindful of your breathing through your nose – is it clear and unobstructed, or do you often feel congested?\n\n" +
                        "Tracking the appearance of your nose and any associated sensations can provide insights into skin health, sinus conditions, or even environmental sensitivities. For instance, increased oiliness or blackheads might prompt adjustments to your skincare routine. Persistent redness could be related to rosacea or irritation. Nasal congestion or changes in breathing patterns might indicate allergies, a cold, or other sinus issues. This self-awareness can help you tailor your care and identify when to seek advice for persistent concerns.\n\n" +
                        "Consistent attention to your nose contributes to both aesthetic awareness and respiratory well-being. Maintaining clear nasal passages supports optimal breathing, sleep quality, and even athletic performance. Proper skincare for the nose can manage common issues like oiliness or dryness, enhancing its appearance. By being attuned to this central facial feature, you support its crucial functions and ensure it contributes positively to your overall facial harmony and health."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_13,
                "Ear",
                "The ears are complex sensory organs responsible for our sense of hearing, enabling us to perceive sound, understand speech, and appreciate music. They also play a crucial role in maintaining our sense of balance and spatial orientation. While the external ear (auricle or pinna) is the visible part, contributing to facial aesthetics and helping to funnel sound, the intricate structures of the middle and inner ear perform the sophisticated tasks of sound transduction and equilibrium.\n\n" +
                        "When observing your external ears, note their shape, size, and symmetry. Examine the contours of the auricle, including the lobe, helix, and concha. Assess the skin for its texture, color, and any signs of dryness, flakiness, redness, or lesions. Check behind the ears and in the creases for cleanliness and skin condition. If you wear earrings, observe the piercing sites for any irritation or signs of infection. Be mindful of any tenderness, itching, or discharge from the ear canal, though internal observation is beyond simple visual assessment.\n\n" +
                        "Regularly checking the visible parts of your ears can help you maintain good hygiene and spot early signs of skin issues or irritation. For example, dryness or flakiness might indicate a need for gentle moisturizing, while redness or tenderness around a piercing could signal an infection. Awareness of any unusual lumps or skin changes should prompt professional consultation. This simple observation routine can also help you ensure earrings are clean and backings are secure, preventing loss or discomfort.\n\n" +
                        "Consistent attention to your ears supports their health and aesthetic contribution. Good hygiene helps prevent infections and buildup in the external ear. Protecting ears from excessive noise is crucial for preserving hearing. While this visual scan focuses on the external ear, it encourages a broader awareness of ear health, reminding us of the importance of these sophisticated organs for communication, balance, and our overall experience of the world."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_96,
                "Lip",
                "Lips are a highly sensitive and expressive facial feature, playing a central role in speech articulation, food intake, and tactile sensation. Their distinct reddish hue is due to the thinness of the skin and the rich network of underlying blood vessels. Lips are also a key element of facial aesthetics and communication, conveying emotions and contributing significantly to attractiveness and expression. Their delicate skin lacks the oil and sweat glands found elsewhere, making them particularly prone to dryness and environmental damage.\n\n" +
                        "When observing your lips, note their overall shape, fullness, and symmetry. Assess their color – is it a healthy pink or reddish tone, or do they appear pale, bluish, or unusually dark? Examine the texture of the lip surface: are they smooth and supple, or dry, chapped, flaky, or cracked? Look at the vermilion border (the line separating the lips from the surrounding skin) for its definition and any signs of irritation or cold sores. Also, be aware of the moisture level – do your lips feel hydrated or parched?\n\n" +
                        "Tracking the condition of your lips can provide direct feedback on your hydration levels, dietary habits, and exposure to environmental factors like sun, wind, and dry air. For instance, chapped lips are a common sign of dehydration or exposure to harsh weather, prompting increased water intake or the use of protective lip balm. Changes in lip color or persistent sores might warrant attention to rule out underlying issues. This self-awareness allows you to adapt your lip care routine to keep them healthy and comfortable.\n\n" +
                        "Consistent care and observation of your lips are essential for maintaining their health, comfort, and aesthetic appeal. Regular use of moisturizing and sun-protective lip balms can prevent dryness, chapping, and sun damage. Staying well-hydrated also contributes significantly to lip health. Healthy, well-cared-for lips enhance your smile, facilitate clear speech, and contribute to overall facial attractiveness and confidence."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_94,
                "Knee",
                "The knees are among the largest and most complex joints in the body, acting as crucial hinges that connect the thigh bone (femur) to the shin bone (tibia). They bear significant weight and are essential for a wide range of movements, including walking, running, jumping, squatting, and climbing. The knee joint's intricate structure, involving bones, cartilage, ligaments, and tendons, allows for flexion and extension while providing stability, but also makes it susceptible to injury and wear over time.\n\n" +
                        "When observing your knees, note their overall shape and symmetry, comparing one to the other. Look for any visible swelling, redness, or bruising around the joint. Assess the skin overlying the knee for its texture and any scars or abrasions. Consider the alignment of your knees when standing – do they appear straight, bow-legged (varus), or knock-kneed (valgus)? Be mindful of any sensations such as warmth, tenderness to touch, clicking, popping, or feelings of instability during movement, though this scan focuses on visual cues.\n\n" +
                        "Regularly checking the appearance of your knees can help you identify early signs of inflammation, injury, or developing conditions. For example, localized swelling after an activity might indicate a strain or minor injury, prompting rest and ice. Observing persistent misalignment could be a cue to consider strengthening exercises or professional assessment for biomechanics. This visual awareness complements any physical sensations, helping you correlate activities with their impact on your knee joints.\n\n" +
                        "Consistent attention to your knees is vital for maintaining mobility and preventing long-term issues, especially if you are active or have a history of knee problems. Strengthening the muscles that support the knee (quadriceps, hamstrings, and calves), maintaining a healthy weight, and using proper form during exercise can significantly reduce stress on the joints. By being attuned to their appearance and how they feel, you can take proactive steps to protect these critical joints, ensuring they support an active and comfortable lifestyle."
        ));

        list.add(new AnatomyDataModel(
                R.drawable.img_x_image_106,
                "Stomach",
                "The stomach, or abdominal area, is a central region of the body housing vital digestive organs, including the stomach itself, intestines, liver, and pancreas. It also comprises key core muscles that are essential for posture, stability, movement, and protecting the spine. Aesthetically, the appearance of the stomach area – its tone, contour, and skin condition – is often a focus of personal fitness goals and body image perception.\n\n" +
                        "When observing your stomach area, consider its overall contour and shape. Assess the muscle tone – do your abdominal muscles feel firm and engaged, or relatively soft? Note the distribution of subcutaneous fat and the appearance of the skin, looking for its elasticity, texture, and any stretch marks or loose skin. Observe your posture – does a strong core contribute to an upright stance, or does weakness lead to slouching or a protruding abdomen? Be mindful of any bloating or distension, which can vary with diet and digestion.\n\n" +
                        "Tracking the appearance and feel of your stomach area can provide valuable feedback on your diet, exercise routine, and overall lifestyle. For instance, increased muscle definition can be a positive indicator of consistent core workouts, while persistent bloating might prompt you to examine your dietary choices or eating habits. Changes in skin elasticity or the appearance of stretch marks can be related to weight fluctuations or aging. This self-awareness empowers you to make adjustments to your fitness regimen, nutritional intake, or skincare to align with your personal health and aesthetic goals.\n\n" +
                        "Consistent attention to your stomach area promotes a holistic approach to core strength, digestive health, and body confidence. A strong core is fundamental for good posture, reduced risk of back pain, and efficient movement in daily activities and sports. By monitoring this region, you can stay motivated with fitness goals, make informed dietary choices, and cultivate a positive body image, recognizing that health and strength come in many shapes and sizes."
        ));

        return list;
    }


    @Override
    public void onBackPressed() {
        handleBackNavigation();
    }
}